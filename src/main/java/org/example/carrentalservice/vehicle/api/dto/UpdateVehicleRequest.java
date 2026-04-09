package org.example.carrentalservice.vehicle.api.dto;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateVehicleRequest {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Integer modelYear;

    @NotBlank
    private String plateNumber;

    @NotNull
    private Boolean available;

    @NotBlank
    private String conditionStatus;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal dailyRate;
}