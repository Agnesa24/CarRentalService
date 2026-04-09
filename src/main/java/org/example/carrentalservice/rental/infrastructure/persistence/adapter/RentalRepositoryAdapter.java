package org.example.carrentalservice.rental.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.example.carrentalservice.rental.api.mapper.RentalMapper;
import org.example.carrentalservice.rental.domain.model.Rental;
import org.example.carrentalservice.rental.domain.repository.RentalRepository;
import org.example.carrentalservice.rental.infrastructure.persistence.repository.SpringDataRentalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryAdapter implements RentalRepository {
    private final SpringDataRentalRepository repository;
    @Override
    public Rental save(Rental rental) {
        return
                RentalMapper.toDomain(repository.save(RentalMapper.toJpa(rental)));
    }
    @Override
    public Optional<Rental> findById(Long id) {
        return repository.findById(id).map(RentalMapper::toDomain);
    }
    @Override
    public List<Rental> findAll() {
        return
                repository.findAll().stream().map(RentalMapper::toDomain).toList();
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}