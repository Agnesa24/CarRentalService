package org.example.carrentalservice.vehicle.api.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponse {
    private Long vehicleId;
    private String brand;
    private String model;
    private Integer vehicleYear;
    private String plateNumber;
    private String status;
    private BigDecimal dailyRate;
}
