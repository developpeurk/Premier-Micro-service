package com.lambarki.yassine.bankserviceyassinelambarki.dtos;

import com.lambarki.yassine.bankserviceyassinelambarki.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private String id;
    private Double balance;
    private String currency;
    private AccountType type;

}
