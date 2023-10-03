package com.kutluayulutas.account.dto;


import com.kutluayulutas.account.modal.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private String id;
    private TransactionType transactionType=TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
