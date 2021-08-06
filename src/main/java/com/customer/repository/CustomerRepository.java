package com.customer.repository;

import com.customer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    Optional<Customer> findById(Long customerId);
}
