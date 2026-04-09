package org.example.carrentalservice.vehicle.service;

import lombok.RequiredArgsConstructor;
import org.example.carrentalservice.shared.exception.DuplicateResourceException;
import org.example.carrentalservice.shared.exception.ResourceNotFoundException;
import org.example.carrentalservice.vehicle.api.dto.CreateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.UpdateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.VehicleResponse;
import org.example.carrentalservice.vehicle.api.mapper.VehicleMapper;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.domain.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleApplicationService {

    private final VehicleRepository vehicleRepository;

    public VehicleResponse create(CreateVehicleRequest request) {
        if (vehicleRepository.existsByPlateNumber(request.getPlateNumber())) {
            throw new DuplicateResourceException("Vehicle plate number already exists.");
        }
        Vehicle vehicle = VehicleMapper.toDomain(request);
        vehicle.validate();
        return VehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    public List<VehicleResponse> getAll() {
        return vehicleRepository.findAll().stream().map(VehicleMapper::toResponse).toList();
    }

    public VehicleResponse getById(Long id) {
        return VehicleMapper.toResponse(getDomainById(id));
    }

    public Vehicle getDomainById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found."));
    }

    public VehicleResponse update(Long id, UpdateVehicleRequest request) {
        Vehicle vehicle = getDomainById(id);

        if (!vehicle.getPlateNumber().equals(request.getPlateNumber())
                && vehicleRepository.existsByPlateNumber(request.getPlateNumber())) {
            throw new DuplicateResourceException("Vehicle plate number already exists.");
        }

        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setModelYear(request.getModelYear());
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setAvailable(request.getAvailable());
        vehicle.setConditionStatus(request.getConditionStatus());
        vehicle.setDailyRate(request.getDailyRate());
        vehicle.validate();
        return VehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    public void delete(Long id) {
        getById(id);
        vehicleRepository.deleteById(id);
    }

    // already in starter — kept as-is
    public void markUnavailable(Long id) {
        Vehicle vehicle = getDomainById(id);
        vehicle.markUnavailable();
        vehicleRepository.save(vehicle);
    }

    //symmetric method used when a rental is deleted while still active
    public void markAvailable(Long id) {
        Vehicle vehicle = getDomainById(id);
        vehicle.setAvailable(true);
        vehicleRepository.save(vehicle);
    }
}