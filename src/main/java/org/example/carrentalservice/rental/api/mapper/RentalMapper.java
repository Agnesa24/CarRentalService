package org.example.carrentalservice.rental.api.mapper;

import org.example.carrentalservice.billing.domain.model.Invoice;
import org.example.carrentalservice.customer.domain.model.Customer;
import org.example.carrentalservice.rental.api.dto.CreateRentalRequest;
import org.example.carrentalservice.rental.api.dto.RentalModel;
import org.example.carrentalservice.rental.api.dto.RentalResponse;
import org.example.carrentalservice.rental.domain.model.Rental;
import org.example.carrentalservice.rental.infrastructure.persistence.entity.RentalJpaEntity;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;

public class RentalMapper {
    private RentalMapper() {}

    public static Rental toDomain(CreateRentalRequest request) {
        return Rental.builder()
                .customerId(request.getCustomerId())
                .vehicleId(request.getVehicleId())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status("CREATED")
                .build();
    }
    public static Rental toDomain(RentalJpaEntity entity) {
        return Rental.builder()
                .rentalId(entity.getRentalId())
                .customerId(entity.getCustomerId())
                .vehicleId(entity.getVehicleId())
                .invoiceId(entity.getInvoiceId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .status(entity.getStatus())
                .build();
    }
    public static RentalJpaEntity toJpa(Rental rental) {
        return RentalJpaEntity.builder()
                .rentalId(rental.getRentalId())
                .customerId(rental.getCustomerId())
                .vehicleId(rental.getVehicleId())
                .invoiceId(rental.getInvoiceId())
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .status(rental.getStatus())
                .build();
    }
    public static RentalResponse toResponse(Rental rental, Customer customer, Vehicle vehicle, Invoice invoice) {
        return RentalResponse.builder()
                .rentalId(rental.getRentalId())
                .customerId(rental.getCustomerId())
                .customerName(customer.getFullName())
                .vehicleId(rental.getVehicleId())
                .vehicleName(vehicle.getBrand() + " " + vehicle.getModel())
                .invoiceId(rental.getInvoiceId())
                .amount(invoice.getAmount())
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .status(rental.getStatus())
                .build();
    }
    public static RentalModel toModel(RentalResponse response) {
        RentalModel model = new RentalModel();
        model.setRentalId(response.getRentalId());
        model.setCustomerId(response.getCustomerId());
        model.setCustomerName(response.getCustomerName());
        model.setVehicleId(response.getVehicleId());
        model.setVehicleName(response.getVehicleName());
        model.setInvoiceId(response.getInvoiceId());
        model.setAmount(response.getAmount());
        model.setStartDate(response.getStartDate());
        model.setEndDate(response.getEndDate());
        model.setStatus(response.getStatus());
        return model;
    }
}

