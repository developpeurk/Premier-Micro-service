package com.lambarki.yassine.bankserviceyassinelambarki.web;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.BankAccount;
import com.lambarki.yassine.bankserviceyassinelambarki.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable("id") String id) {
        return bankAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account  %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        if(bankAccount.getId() == null)
            bankAccount.setId(UUID.randomUUID().toString());

        if(bankAccount.getCreatedAt() == null)
            bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable("id") String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();

        if(bankAccount.getBalance() !=null)
            account.setBalance(bankAccount.getBalance());

        if(bankAccount.getCreatedAt() != null)
            account.setCreatedAt(new Date());

        if(bankAccount.getType() != null)
            account.setType(bankAccount.getType());

        if(bankAccount.getCurrency() != null)
            account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable("id") String id) {
        bankAccountRepository.deleteById(id);
    }

}
