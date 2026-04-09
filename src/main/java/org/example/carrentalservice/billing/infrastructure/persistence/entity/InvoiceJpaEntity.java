package org.example.carrentalservice.billing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private Long rentalId;
    //private Double amount;
    @Column(nullable = false) //i added this too
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDate paymentDate;
}