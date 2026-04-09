package org.example.carrentalservice.vehicle.api.dto;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateVehicleRequest {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Integer modelYear; // ✅ was vehicleYear

    @NotBlank
    private String plateNumber;

    @NotNull
    private Boolean available; // ✅ was missing or String status

    @NotBlank
    private String conditionStatus; // ✅ was missing

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal dailyRate;
}