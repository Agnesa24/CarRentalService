package org.example.carrentalservice.vehicle.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String brand;
    private String model;
    private Integer modelYear;
    private String plateNumber;
    private Boolean available;
    private String conditionStatus;
    private Double dailyRate;
}

