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
public class AccountCustomerDto {
    private String id;
    private String name;
    private String surname;


}
