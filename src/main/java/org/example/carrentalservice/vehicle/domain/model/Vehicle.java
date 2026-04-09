package org.example.carrentalservice.vehicle.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private Long vehicleId;
    private String brand;
    private String model;
    private Integer vehicleYear;
    private String plateNumber;
    private String status;
    private BigDecimal dailyRate;

    public void validate() {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand is required.");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model is required.");
        }
        if (vehicleYear == null) {
            throw new IllegalArgumentException("Vehicle year is required.");
        }
        if (plateNumber == null || plateNumber.isBlank()) {
            throw new IllegalArgumentException("Plate number is required.");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status is required.");
        }
        if (dailyRate == null || dailyRate.signum() < 0) {
            throw new IllegalArgumentException("Daily rate must be valid.");
        }
    }
}