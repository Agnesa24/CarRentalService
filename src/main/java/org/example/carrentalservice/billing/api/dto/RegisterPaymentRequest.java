package org.example.carrentalservice.billing.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterPaymentRequest {
    @NotNull
    private LocalDate paymentDate;
}

