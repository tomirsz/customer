package com.customer.contoller;

import com.customer.exception.CustomerNotFoundException;
import com.customer.model.dto.AccountDto;
import com.customer.model.dto.CardDto;
import com.customer.model.dto.CustomerDto;
import com.customer.model.response.GetCustomerProductsResponse;
import com.customer.model.response.GetCustomerResponse;
import com.customer.service.CustomerService;
import com.customer.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController("v1/")
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;

    @GetMapping("customer/{idCustomer}")
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable long idCustomer) {
        try {
            return ResponseEntity.ok().body(new GetCustomerResponse(customerService.fetchCustomer(idCustomer)));
        } catch (CustomerNotFoundException e) {
            log.error("Customer with id: {} not found", idCustomer);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("customer/{customerId}/products")
    public ResponseEntity<GetCustomerProductsResponse> getCustomerProducts(@PathVariable Long customerId) {
        CustomerDto customerDto = null;
        try {
            customerDto = customerService.fetchCustomer(customerId);
        } catch (CustomerNotFoundException e) {
            log.error("Customer with id: {} not found", customerId);
            return ResponseEntity.notFound().build();
        }

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        List<CardDto> customerCards = productService.findCustomerCards(customerId);

        return ResponseEntity.ok().body(GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstName() + " " + customerDto.getLastName())
                .accounts(customerAccounts)
                .cards(customerCards)
                .build());
    }
}
