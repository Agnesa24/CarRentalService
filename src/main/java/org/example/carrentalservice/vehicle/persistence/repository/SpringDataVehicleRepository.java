package org.example.carrentalservice.vehicle.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.example.carrentalservice.vehicle.persistence.entity.VehicleJpaEntity;

public interface SpringDataVehicleRepository extends JpaRepository<VehicleJpaEntity, Long> {
    boolean existsByPlateNumber(String plateNumber);
}