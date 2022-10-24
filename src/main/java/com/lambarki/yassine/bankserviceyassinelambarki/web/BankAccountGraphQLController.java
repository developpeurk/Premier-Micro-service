package com.lambarki.yassine.bankserviceyassinelambarki.web;

import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountRequestDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountResponseDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountResponseDTO> accountsList() {
        return bankAccountService.getAllBankAccounts();

    }

    @QueryMapping(name = "accountById")
    public BankAccountResponseDTO bankAccountById(@Argument String id) {
        return bankAccountService.getBankAccount(id);

    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.save(bankAccount);
    }
}

