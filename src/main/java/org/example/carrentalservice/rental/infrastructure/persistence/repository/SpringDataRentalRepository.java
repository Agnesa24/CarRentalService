package org.example.carrentalservice.rental.infrastructure.persistence.repository;

import org.example.carrentalservice.rental.infrastructure.persistence.entity.RentalJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRentalRepository extends
        JpaRepository<RentalJpaEntity, Long> {
}
