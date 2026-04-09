package org.example.carrentalservice.vehicle.persistence.adapter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.example.carrentalservice.vehicle.api.mapper.VehicleMapper;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.domain.repository.VehicleRepository;
import org.example.carrentalservice.vehicle.persistence.entity.VehicleJpaEntity;
import org.example.carrentalservice.vehicle.persistence.repository.SpringDataVehicleRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VehicleRepositoryAdapter implements VehicleRepository {

    private final SpringDataVehicleRepository repository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleJpaEntity entity = repository.save(VehicleMapper.toJpa(vehicle));
        return VehicleMapper.fromJpa(entity);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id).map(VehicleMapper::fromJpa);
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll().stream()
                .map(VehicleMapper::fromJpa)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByPlateNumber(String plateNumber) {
        return repository.existsByPlateNumber(plateNumber);
    }
}