package com.kutluayulutas.account.service;

import com.kutluayulutas.account.dto.CustomerDto;
import com.kutluayulutas.account.dto.CustomerDtoConverter;
import com.kutluayulutas.account.exception.CustomerNotFoundException;
import com.kutluayulutas.account.modal.Customer;
import com.kutluayulutas.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {


    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter customerDtoConverter;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock(CustomerDtoConverter.class);
        customerService = new CustomerService(customerRepository, customerDtoConverter);
    }

    @Test
    public void getCustomerById_whenCustomerExists_shouldReturnCustomer() {

        Customer mockCustomer = new Customer("1", "","",new HashSet<>());
        CustomerDto expectedDto = new CustomerDto("1", "","",new HashSet<>());

        when(customerRepository.findById("1")).thenReturn(Optional.of(mockCustomer));

        when(customerDtoConverter.convertToCustomerDto(mockCustomer)).thenReturn(expectedDto);

        CustomerDto actualDto = customerService.getCustomerById("1");

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void findCustomerById_whenCustomerExist_shouldReturnCustomer(){
        Customer customer = new Customer("1", "","",new HashSet<>());

        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));

        Customer result = customerService.findCustomerById(customer.getId());

        assertEquals(result,customer);
    }

    @Test
    public void findCustomerById_whenCustomerDoesNotExist_shouldReturnCustomerNotFoundException(){
        Customer customer = new Customer("2", "","",new HashSet<>());

        when(customerRepository.findById("2")).thenReturn(Optional.empty());

        try {
            customerService.findCustomerById("1");
            fail("CustomerNotFoundException , expected.");
        } catch (CustomerNotFoundException e) {
            assertEquals("Customer could not find by id: 1", e.getMessage());
        }

    }

}