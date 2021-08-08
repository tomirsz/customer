package com.customer.provider;

import com.customer.connector.AccountsConnector;
import com.customer.model.dto.AccountDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    @CircuitBreaker(name = "accounts", fallbackMethod = "fallbackGetAccounts")
    public List<AccountDto> getCustomerAccounts(long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()))
                .collect(Collectors.toList());
    }
    private List<AccountDto> fallbackGetAccounts(long customerId, Throwable t) {
        return Collections.emptyList();
    }
}
