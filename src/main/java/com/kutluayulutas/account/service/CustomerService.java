package com.kutluayulutas.account.service;

import com.kutluayulutas.account.dto.CustomerDto;
import com.kutluayulutas.account.dto.CustomerDtoConverter;
import com.kutluayulutas.account.exception.CustomerNotFoundException;
import com.kutluayulutas.account.modal.Customer;
import com.kutluayulutas.account.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    protected Customer findCustomerById(String id){
        return customerRepository
                .findById(id).orElseThrow(() ->
                        new CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }
}
