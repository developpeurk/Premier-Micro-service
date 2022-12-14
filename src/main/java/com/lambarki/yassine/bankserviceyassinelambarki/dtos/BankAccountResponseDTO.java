package com.lambarki.yassine.bankserviceyassinelambarki.dtos;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.Customer;
import com.lambarki.yassine.bankserviceyassinelambarki.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private LocalDate createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
    private Customer customer;
}
