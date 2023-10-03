package com.kutluayulutas.account.dto;


import com.kutluayulutas.account.modal.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDto convert(Account from){
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCredationDate(),
                customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConverter::convert).collect(Collectors.toSet()));
    }
}
