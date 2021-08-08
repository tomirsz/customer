package com.customer.connector;

import com.customer.model.response.GetAccountsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Accounts")
public interface AccountsConnector {

    @GetMapping("/accounts")
    GetAccountsResponse getAccounts(@RequestParam(name = "customerId") long customerId);
}