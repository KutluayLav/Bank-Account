package com.kutluayulutas.account.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private BigDecimal balance= BigDecimal.ZERO;
    private LocalDateTime credationDate;
    private AccountCustomerDto customer;
    private Set<TransactionDto> transactions;


}
