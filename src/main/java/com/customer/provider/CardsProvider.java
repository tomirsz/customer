package com.customer.provider;

import com.customer.connector.CardsConnector;
import com.customer.model.dto.CardDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardsProvider {

    private final CardsConnector cardsConnector;

    @CircuitBreaker(name = "cards", fallbackMethod = "fallbackGetCards")
    public List<CardDto> getCustomerAccounts(long customerId) {
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(
                        card.getId(),
                        card.getCardNumber(),
                        card.getCardType(),
                        card.getCustomerId()))
                .collect(Collectors.toList());
    }
    private List<CardDto> fallbackGetCards(long customerId, Throwable t) {
        return Collections.emptyList();
    }
}
