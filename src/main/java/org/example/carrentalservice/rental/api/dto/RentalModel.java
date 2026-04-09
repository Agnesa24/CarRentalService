package org.example.carrentalservice.rental.api.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class RentalModel extends RepresentationModel<RentalModel> {
    private Long rentalId;
    private Long customerId;
    private String customerName;
    private Long vehicleId;
    private String vehicleName;
    private Long invoiceId;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
