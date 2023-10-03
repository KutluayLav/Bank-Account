package com.kutluayulutas.account.dto;


import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String Surname;
    private Set<CustomerAccountDto> accounts;
}
