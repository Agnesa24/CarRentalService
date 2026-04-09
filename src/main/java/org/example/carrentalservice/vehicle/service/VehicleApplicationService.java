package org.example.carrentalservice.vehicle.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.carrentalservice.exception.DuplicateResourceException;
import org.example.carrentalservice.exception.ResourceNotFoundException;
import org.example.carrentalservice.vehicle.api.dto.CreateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.UpdateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.VehicleResponse;
import org.example.carrentalservice.vehicle.api.mapper.VehicleMapper;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.domain.repository.VehicleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleApplicationService {

    private final VehicleRepository vehicleRepository;

    public VehicleResponse create(CreateVehicleRequest request) {
        if (vehicleRepository.existsByPlateNumber(request.getPlateNumber())) {
            throw new DuplicateResourceException("Vehicle plate number already exists.");
        }

        Vehicle vehicle = VehicleMapper.fromRequest(request);
        vehicle.validate();

        return VehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    public List<VehicleResponse> getAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper::toResponse)
                .toList();
    }

    public VehicleResponse getById(Long id) {
        return VehicleMapper.toResponse(
                vehicleRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found."))
        );
    }

    public Vehicle getDomainById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found."));
    }

    public VehicleResponse update(Long id, UpdateVehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found."));

        if (!vehicle.getPlateNumber().equals(request.getPlateNumber())
                && vehicleRepository.existsByPlateNumber(request.getPlateNumber())) {
            throw new DuplicateResourceException("Vehicle plate number already exists.");
        }

        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setVehicleYear(request.getVehicleYear());
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setStatus(request.getStatus());
        vehicle.setDailyRate(request.getDailyRate());

        vehicle.validate();

        return VehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    public void delete(Long id) {
        vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found."));
        vehicleRepository.deleteById(id);
    }
}