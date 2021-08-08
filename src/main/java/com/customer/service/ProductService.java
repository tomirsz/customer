package com.customer.service;

import com.customer.model.dto.AccountDto;
import com.customer.provider.AccountsProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final AccountsProvider accountProvider;

    public List<AccountDto> findCustomerAccounts(long customerId) {
        return accountProvider.getCustomerAccounts(customerId);
    }

}
