package org.example.carrentalservice.billing.application.service;

import org.example.carrentalservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.carrentalservice.billing.api.dto.CreateInvoiceRequest;
import org.example.carrentalservice.billing.api.dto.InvoiceResponse;
import org.example.carrentalservice.billing.api.dto.RegisterPaymentRequest;
import org.example.carrentalservice.billing.api.dto.UpdateInvoiceRequest;
import org.example.carrentalservice.billing.api.mapper.InvoiceMapper;
import org.example.carrentalservice.billing.domain.model.Invoice;
import org.example.carrentalservice.billing.domain.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceApplicationService {
    private final InvoiceRepository invoiceRepository;
    public InvoiceResponse create(CreateInvoiceRequest request) {
        Invoice invoice = InvoiceMapper.toDomain(request);
        invoice.validate();
        return InvoiceMapper.toResponse(invoiceRepository.save(invoice));
    }
    public Invoice createFromAmount(Double amount) {
        Invoice invoice = Invoice.builder()
                .amount(amount)
                .paymentStatus("PENDING")
                .build();
        invoice.validate();
        return invoiceRepository.save(invoice);
    }
    public List<InvoiceResponse> getAll() {
        return invoiceRepository.findAll().stream().map(InvoiceMapper::toResponse).toList();
    }
    public InvoiceResponse getById(Long id) {
        return InvoiceMapper.toResponse(getDomainById(id));
    }
    public Invoice getDomainById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found."));
    }
    public InvoiceResponse update(Long id, UpdateInvoiceRequest request) {
        Invoice invoice = getDomainById(id);
        invoice.setRentalId(request.getRentalId());
        invoice.setAmount(request.getAmount());
        invoice.setPaymentStatus(request.getPaymentStatus());
        invoice.setPaymentDate(request.getPaymentDate());
        invoice.validate();
        return InvoiceMapper.toResponse(invoiceRepository.save(invoice));
    }
    public InvoiceResponse registerPayment(Long id, RegisterPaymentRequest
            request) {
        Invoice invoice = getDomainById(id);
        invoice.registerPayment(request.getPaymentDate());
        return InvoiceMapper.toResponse(invoiceRepository.save(invoice));
    }
    public void delete(Long id) {
        getById(id);
        invoiceRepository.deleteById(id);
    }
}