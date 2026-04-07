package org.example.carrentalservice.customer.persistence.repository;

import org.example.carrentalservice.customer.persistence.entity.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerJpaEntity, Long> {
    boolean existsByEmail(String email);
}