package org.example.carrentalservice.rental.domain.repository;

import org.example.carrentalservice.rental.domain.model.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    Rental save(Rental rental);
    Optional<Rental> findById(Long id);
    List<Rental> findAll();
    void deleteById(Long id);
}