package org.example.carrentalservice.customer.domain.repository;

import org.example.carrentalservice.customer.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    boolean existsByEmail(String email);
}
