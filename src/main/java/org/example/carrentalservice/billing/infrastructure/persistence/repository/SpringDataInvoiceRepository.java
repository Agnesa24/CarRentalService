package org.example.carrentalservice.billing.infrastructure.persistence.repository;

import org.example.carrentalservice.billing.infrastructure.persistence.entity.InvoiceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataInvoiceRepository extends
        JpaRepository<InvoiceJpaEntity, Long> {
}
