package com.customer.model.response;

import com.customer.model.dto.CustomerDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCustomerResponse {

    private long id;
    private String firstName;
    private String lastName;

    public GetCustomerResponse(CustomerDto dto) {
        this.id = dto.getId();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
    }
}
