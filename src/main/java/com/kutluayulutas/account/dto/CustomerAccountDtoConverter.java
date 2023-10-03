package com.kutluayulutas.account.dto;


import com.kutluayulutas.account.modal.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account){
        return new CustomerAccountDto(account.getId(),
                account.getBalance(),
                account.getTransaction()
                        .stream().map(t -> transactionDtoConverter.convert(t)).collect(Collectors.toSet()),
                account.getCredationDate()
                );
    }
}
