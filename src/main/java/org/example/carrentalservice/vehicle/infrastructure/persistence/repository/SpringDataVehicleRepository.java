package org.example.carrentalservice.vehicle.infrastructure.persistence.repository;

import org.example.carrentalservice.vehicle.infrastructure.persistence.entity.VehicleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataVehicleRepository extends
        JpaRepository<VehicleJpaEntity, Long> {
    boolean existsByPlateNumber(String plateNumber);
}
