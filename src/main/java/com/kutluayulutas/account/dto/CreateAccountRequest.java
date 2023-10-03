package com.kutluayulutas.account.dto;


import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAccountRequest {

    @NotNull
    private String customerId;

    @DecimalMin(value = "0", inclusive = false, message = "initialCredit 0'dan büyük olmalıdır")
    private BigDecimal initialCredit;
}
