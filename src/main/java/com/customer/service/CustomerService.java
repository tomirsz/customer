package com.customer.service;

import com.customer.exception.CustomerNotFoundException;
import com.customer.mapper.CustomerMapper;
import com.customer.model.dto.CustomerDto;
import com.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDto fetchCustomer(long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).map(customerMapper::mapToCustomerDto)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer %s not exists", id)));
    }
}

