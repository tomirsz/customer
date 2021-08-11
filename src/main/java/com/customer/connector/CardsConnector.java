package com.customer.connector;

import com.customer.model.response.GetCardsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsConnector {

     @GetMapping("/cards")
     GetCardsResponse getCards(@RequestParam(name = "customerId") long customerId);
}
