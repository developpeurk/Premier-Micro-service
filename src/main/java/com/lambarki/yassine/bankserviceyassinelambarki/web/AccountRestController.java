package com.lambarki.yassine.bankserviceyassinelambarki.web;

import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountRequestDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountResponseDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {

    private BankAccountService bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable("id") String id) {
        return bankAccountService.getBankAccount(id);

    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.save(bankAccountRequestDTO);
    }


    @PutMapping(path = "/bankAccounts/{id}")
    public BankAccountResponseDTO update(@RequestBody BankAccountRequestDTO bankAccountRequestDTO, @PathVariable String id){
        bankAccountRequestDTO.setId(id);
        return bankAccountService.save(bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable("id") String id) {
        bankAccountService.deleteBankAccount(id);
    }

}
