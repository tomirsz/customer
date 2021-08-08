package com.customer.service;

import com.customer.model.dto.AccountDto;
import com.customer.model.dto.CardDto;
import com.customer.provider.AccountsProvider;
import com.customer.provider.CardsProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final AccountsProvider accountProvider;
    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(long customerId) {
        return accountProvider.getCustomerAccounts(customerId);
    }

    public List<CardDto> findCustomerCards(long customerId) {
        return cardsProvider.getCustomerAccounts(customerId);
    }

}
