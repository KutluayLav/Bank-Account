package com.kutluayulutas.account.dto;


import com.kutluayulutas.account.modal.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if (from == null){
            return new AccountCustomerDto("","","");
        }else {
            return new AccountCustomerDto(from.getId(),from.getName(),from.getSurname());
        }
    }


    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId()
                ,from.getName()
                ,from.getSurname(),
                 from.getAccount().stream().map(converter::convert).collect(Collectors.toSet())
                );
    }
}
