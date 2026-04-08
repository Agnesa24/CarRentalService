package org.example.carrentalservice.billing.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InvoiceResponse {
    private Long invoiceId;
    private Long rentalId;
    private Double amount;
    private String paymentStatus;
    private LocalDate paymentDate;
}
