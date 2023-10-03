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
public class CustomerAccountDto {
    private String id;
    private BigDecimal balance=BigDecimal.ZERO;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;



}
