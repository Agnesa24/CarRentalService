package org.example.carrentalservice.vehicle.api.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
public class VehicleResponse {

    private Long vehicleId;
    private String brand;
    private String model;
    private Integer modelYear;
    private String plateNumber;
    private Boolean available;
    private String conditionStatus;
    private BigDecimal dailyRate;
}