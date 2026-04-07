package customer.persistence.repository;

import customer.persistence.entity.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerJpaEntity, Long> {
    boolean existsByEmail(String email);
}