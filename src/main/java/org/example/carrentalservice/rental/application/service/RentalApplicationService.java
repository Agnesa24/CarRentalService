package org.example.carrentalservice.rental.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.carrentalservice.billing.application.service.InvoiceApplicationService;
import org.example.carrentalservice.billing.domain.model.Invoice;
import org.example.carrentalservice.customer.domain.model.Customer;
import org.example.carrentalservice.customer.service.CustomerApplicationService;
import org.example.carrentalservice.rental.api.dto.CreateRentalRequest;
import org.example.carrentalservice.rental.api.dto.RentalResponse;
import org.example.carrentalservice.rental.api.dto.UpdateRentalRequest;
import org.example.carrentalservice.rental.api.mapper.RentalMapper;
import org.example.carrentalservice.rental.domain.model.Rental;
import org.example.carrentalservice.rental.domain.repository.RentalRepository;
import org.example.carrentalservice.shared.exception.BusinessRuleException;
import org.example.carrentalservice.shared.exception.ResourceNotFoundException;
import org.example.carrentalservice.vehicle.api.mapper.VehicleMapper;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.service.VehicleApplicationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalApplicationService {

    private final RentalRepository rentalRepository;
    private final CustomerApplicationService customerService;
    private final VehicleApplicationService vehicleService;
    private final InvoiceApplicationService invoiceService;

    @Transactional
    public RentalResponse create(CreateRentalRequest request) {
        Customer customer = customerService.getDomainById(request.getCustomerId());
        if (!Boolean.TRUE.equals(customer.getEligibleToRent())) {
            throw new BusinessRuleException("Customer is not eligible to rent.");
        }

        Vehicle vehicle = vehicleService.getDomainById(request.getVehicleId());
        if (!Boolean.TRUE.equals(vehicle.getAvailable())
                || !"RENTABLE".equalsIgnoreCase(vehicle.getConditionStatus())) {
            throw new BusinessRuleException("Vehicle is not available for rental.");
        }

        Rental rental = RentalMapper.toDomain(request);
        rental.validate();

        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        if (days <= 0) {
            throw new BusinessRuleException("End date must be after start date.");
        }

        BigDecimal amount = vehicle.getDailyRate().multiply(BigDecimal.valueOf(days));
        Invoice invoice = invoiceService.createFromAmount(amount);
        rental.setInvoiceId(invoice.getInvoiceId());

        Rental saved = rentalRepository.save(rental);
        vehicleService.markUnavailable(vehicle.getVehicleId());

        vehicle.setAvailable(false);
        return RentalMapper.toResponse(saved, customer, vehicle, invoice);
    }

    public List<RentalResponse> getAll() {
        return rentalRepository.findAll().stream().map(this::mapWithAggregates).toList();
    }

    public RentalResponse getById(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found."));
        return mapWithAggregates(rental);
    }

    public RentalResponse update(Long id, UpdateRentalRequest request) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found."));
        rental.setStatus(request.getStatus());
        return mapWithAggregates(rentalRepository.save(rental));
    }

    @Transactional
    public void delete(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found."));

        if ("CREATED".equalsIgnoreCase(rental.getStatus())
                || "ACTIVE".equalsIgnoreCase(rental.getStatus())) {
            vehicleService.markAvailable(rental.getVehicleId());
        }

        rentalRepository.deleteById(id);
    }

    private RentalResponse mapWithAggregates(Rental rental) {
        Customer customer = customerService.getDomainById(rental.getCustomerId());
        Vehicle vehicle = vehicleService.getDomainById(rental.getVehicleId());
        Invoice invoice = invoiceService.getDomainById(rental.getInvoiceId());
        return RentalMapper.toResponse(rental, customer, vehicle, invoice);
    }
}