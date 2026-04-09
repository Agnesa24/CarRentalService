package org.example.carrentalservice.billing.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import java.math.BigDecimal;

@Data
@Builder
public class InvoiceResponse {
    private Long invoiceId;
    private Long rentalId;
    //private Double amount;

    private BigDecimal amount;
    private String paymentStatus;
    private LocalDate paymentDate;
}
