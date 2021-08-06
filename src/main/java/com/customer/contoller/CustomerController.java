package com.customer.contoller;

import com.customer.exception.CustomerNotFoundException;
import com.customer.model.response.GetCustomerResponse;
import com.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController("v1/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("customer/{idCustomer}")
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable long idCustomer) {
        try {
            return ResponseEntity.ok().body(new GetCustomerResponse(customerService.fetchCustomer(idCustomer)));
        } catch (CustomerNotFoundException e) {
            log.error("Customer with id: {} not found", idCustomer);
            return ResponseEntity.notFound().build();
        }
    }
}
