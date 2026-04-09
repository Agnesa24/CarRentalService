package org.example.carrentalservice.vehicle.api.dto;



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
    private Integer vehicleYear;

    @NotBlank
    private String plateNumber;

    @NotBlank
    private String status;

    @NotNull
    private BigDecimal dailyRate;
}