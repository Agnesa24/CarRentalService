package customer.persistence.adapter;

import customer.api.mapper.CustomerMapper;
import customer.domain.model.Customer;
import customer.domain.repository.CustomerRepository;
import customer.persistence.entity.CustomerJpaEntity;
import customer.persistence.repository.SpringDataCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final SpringDataCustomerRepository repository;

    @Override
    public Customer save(Customer customer) {
        CustomerJpaEntity entity = repository.save(CustomerMapper.toJpa(customer));
        return CustomerMapper.fromJpa(entity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id).map(CustomerMapper::fromJpa);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll().stream()
                .map(CustomerMapper::fromJpa)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}