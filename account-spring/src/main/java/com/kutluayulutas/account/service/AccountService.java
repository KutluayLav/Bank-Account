package com.kutluayulutas.account.service;

import com.kutluayulutas.account.dto.AccountDto;
import com.kutluayulutas.account.dto.AccountDtoConverter;
import com.kutluayulutas.account.dto.CreateAccountRequest;
import com.kutluayulutas.account.modal.Account;
import com.kutluayulutas.account.modal.Customer;
import com.kutluayulutas.account.modal.Transaction;
import com.kutluayulutas.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService{

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer=customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account=new Account(createAccountRequest.getInitialCredit(), LocalDateTime.now(),customer);

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
            Transaction transaction=transactionService
                    .initiateMoney(account,createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }
}
