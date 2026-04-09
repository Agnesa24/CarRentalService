package org.example.carrentalservice.customer.service;

import org.example.carrentalservice.customer.api.dto.CreateCustomerRequest;
import org.example.carrentalservice.customer.api.dto.CustomerResponse;
import org.example.carrentalservice.customer.api.dto.UpdateCustomerRequest;
import org.example.carrentalservice.customer.api.mapper.CustomerMapper;
import org.example.carrentalservice.customer.domain.model.Customer;
import org.example.carrentalservice.customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.carrentalservice.exception.DuplicateResourceException;
import org.example.carrentalservice.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerApplicationService {

    private final CustomerRepository customerRepository;

    public CustomerResponse create(CreateCustomerRequest request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Customer email already exists.");
        }

        Customer customer = CustomerMapper.fromRequest(request);
        customer.validate();

        return CustomerMapper.toResponse(customerRepository.save(customer));
    }

    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toResponse)
                .toList();
    }

    public CustomerResponse getById(Long id) {
        return CustomerMapper.toResponse(
                customerRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found."))
        );
    }

    public Customer getDomainById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found."));
    }

    public CustomerResponse update(Long id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found."));

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setLicenseNumber(request.getLicenseNumber());
        customer.setLicenseExpiryDate(request.getLicenseExpiryDate());
        customer.setEligibleToRent(request.getEligibleToRent());

        customer.validate();

        return CustomerMapper.toResponse(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found."));
        customerRepository.deleteById(id);
    }
}