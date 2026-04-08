package org.example.carrentalservice.billing.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.carrentalservice.billing.api.dto.CreateInvoiceRequest;
import org.example.carrentalservice.billing.api.dto.InvoiceResponse;
import org.example.carrentalservice.billing.api.dto.RegisterPaymentRequest;
import org.example.carrentalservice.billing.api.dto.UpdateInvoiceRequest;
import org.example.carrentalservice.billing.application.service.InvoiceApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceApplicationService service;
    @PostMapping
    public ResponseEntity<InvoiceResponse> create(@Valid @RequestBody CreateInvoiceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<InvoiceResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponse> update(@PathVariable Long id, @Valid
    @RequestBody UpdateInvoiceRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
    @PatchMapping("/{id}/payment")
    public ResponseEntity<InvoiceResponse> registerPayment(@PathVariable Long id, @Valid @RequestBody RegisterPaymentRequest request) {
        return ResponseEntity.ok(service.registerPayment(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}