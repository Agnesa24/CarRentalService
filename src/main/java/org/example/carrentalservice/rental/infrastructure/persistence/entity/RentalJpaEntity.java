package org.example.carrentalservice.rental.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private Long customerId;
    private Long vehicleId;
    private Long invoiceId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
