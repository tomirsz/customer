package com.customer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDto {

    private Long id;
    private String cardNumber;
    private String cardType;
    private Long customerId;
}
