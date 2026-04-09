package org.example.carrentalservice.vehicle.domain.model;

import lombok.*;
import org.example.carrentalservice.shared.exception.BusinessRuleException;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    private Long vehicleId;
    private String brand;
    private String model;
    private Integer modelYear;
    private String plateNumber;
    private Boolean available;
    private String conditionStatus;
    private BigDecimal dailyRate;

    public void validate() {
        if (dailyRate == null || dailyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Daily rate must be greater than 0.");
        }
    }

    public void markUnavailable() {
        if (!Boolean.TRUE.equals(available)) {
            throw new BusinessRuleException("Vehicle is already unavailable.");
        }
        this.available = false;
    }

    // symmetric domain method
    public void markAvailable() {
        if (Boolean.TRUE.equals(available)) {
            throw new BusinessRuleException("Vehicle is already available.");
        }
        this.available = true;
    }
}