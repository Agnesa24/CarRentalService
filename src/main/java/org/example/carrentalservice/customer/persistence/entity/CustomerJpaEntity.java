package org.example.carrentalservice.customer.persistence.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "customers")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class CustomerJpaEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long customerId;
//
//    private String fullName;
//    private String email;
//    private String phone;
//    private String licenseNumber;
//    private LocalDate licenseExpiryDate;
//    private Boolean eligibleToRent;
//}






import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String fullName;
    private String email;
    private String phone;
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
    private Boolean eligibleToRent;
}