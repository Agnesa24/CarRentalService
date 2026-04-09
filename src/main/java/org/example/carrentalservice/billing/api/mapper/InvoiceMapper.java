//package org.example.carrentalservice.billing.api.mapper;
//
//import org.example.carrentalservice.billing.api.dto.CreateInvoiceRequest;
//import org.example.carrentalservice.billing.api.dto.InvoiceResponse;
//import org.example.carrentalservice.billing.domain.model.Invoice;
//import org.example.carrentalservice.billing.infrastructure.persistence.entity.InvoiceJpaEntity;
//
//public class InvoiceMapper {
//    private InvoiceMapper() {}
//    public static Invoice toDomain(CreateInvoiceRequest request) {
//        return Invoice.builder()
//                .rentalId(request.getRentalId())
//                .amount(request.getAmount())
//                .paymentStatus(request.getPaymentStatus())
//                .paymentDate(request.getPaymentDate())
//                .build();
//    }
//    public static Invoice toDomain(InvoiceJpaEntity entity) {
//        return Invoice.builder()
//                .invoiceId(entity.getInvoiceId())
//                .rentalId(entity.getRentalId())
//                .amount(entity.getAmount())
//                .paymentStatus(entity.getPaymentStatus())
//                .paymentDate(entity.getPaymentDate())
//                .build();
//    }
//    public static InvoiceJpaEntity toJpa(Invoice invoice) {
//        return InvoiceJpaEntity.builder()
//                .invoiceId(invoice.getInvoiceId())
//                .rentalId(invoice.getRentalId())
//                .amount(invoice.getAmount())
//                .paymentStatus(invoice.getPaymentStatus())
//                .paymentDate(invoice.getPaymentDate())
//                .build();
//    }
//
//    public static InvoiceResponse toResponse(Invoice invoice) {
//        return InvoiceResponse.builder()
//                .invoiceId(invoice.getInvoiceId())
//                .rentalId(invoice.getRentalId())
//                .amount(invoice.getAmount())
//                .paymentStatus(invoice.getPaymentStatus())
//                .paymentDate(invoice.getPaymentDate())
//                .build();
//    }
//}



package org.example.carrentalservice.billing.api.mapper;

import org.example.carrentalservice.billing.api.dto.CreateInvoiceRequest;
import org.example.carrentalservice.billing.api.dto.InvoiceResponse;
import org.example.carrentalservice.billing.domain.model.Invoice;
import org.example.carrentalservice.billing.infrastructure.persistence.entity.InvoiceJpaEntity;

public class InvoiceMapper {

    private InvoiceMapper() {
    }

    public static Invoice toDomain(CreateInvoiceRequest request) {
        return Invoice.builder()
                .rentalId(request.getRentalId())
                .amount(request.getAmount())
                .paymentStatus(request.getPaymentStatus())
                .paymentDate(request.getPaymentDate())
                .build();
    }

    public static Invoice toDomain(InvoiceJpaEntity entity) {
        return Invoice.builder()
                .invoiceId(entity.getInvoiceId())
                .rentalId(entity.getRentalId())
                .amount(entity.getAmount())
                .paymentStatus(entity.getPaymentStatus())
                .paymentDate(entity.getPaymentDate())
                .build();
    }

    public static InvoiceJpaEntity toJpa(Invoice invoice) {
        return InvoiceJpaEntity.builder()
                .invoiceId(invoice.getInvoiceId())
                .rentalId(invoice.getRentalId())
                .amount(invoice.getAmount())
                .paymentStatus(invoice.getPaymentStatus())
                .paymentDate(invoice.getPaymentDate())
                .build();
    }

    public static InvoiceResponse toResponse(Invoice invoice) {
        return InvoiceResponse.builder()
                .invoiceId(invoice.getInvoiceId())
                .rentalId(invoice.getRentalId())
                .amount(invoice.getAmount())
                .paymentStatus(invoice.getPaymentStatus())
                .paymentDate(invoice.getPaymentDate())
                .build();
    }
}