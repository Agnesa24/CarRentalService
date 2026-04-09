package org.example.carrentalservice.rental.domain.model;

import lombok.*;
import org.example.carrentalservice.shared.exception.BusinessRuleException;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rental {
    private Long rentalId;
    private Long customerId;
    private Long vehicleId;
    private Long invoiceId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    public void validate() {
        if (startDate == null || endDate == null || !
                endDate.isAfter(startDate)) {
            throw new BusinessRuleException("End date must be after start date.");
        }
    }
}

