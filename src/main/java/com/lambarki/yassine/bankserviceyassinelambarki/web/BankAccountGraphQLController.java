package com.lambarki.yassine.bankserviceyassinelambarki.web;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.BankAccount;
import com.lambarki.yassine.bankserviceyassinelambarki.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();

    }

    @QueryMapping(name = "accountById")
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account with %s not found", id)));

    }
}
