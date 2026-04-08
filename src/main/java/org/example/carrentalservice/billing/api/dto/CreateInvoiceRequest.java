package org.example.carrentalservice.billing.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateInvoiceRequest {
    private Long rentalId;
    @NotNull
    @DecimalMin("0.01")
    private Double amount;
    @NotBlank
    private String paymentStatus;
    private LocalDate paymentDate;
}
