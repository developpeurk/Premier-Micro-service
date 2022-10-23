package com.lambarki.yassine.bankserviceyassinelambarki.services;

import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountRequestDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountResponseDTO;

import java.util.List;


public interface BankAccountService {
     BankAccountResponseDTO save(BankAccountRequestDTO bankAccountDTO);
     BankAccountResponseDTO getBankAccount(String id);
     BankAccountResponseDTO update(BankAccountRequestDTO bankAccountRequestDTO);
     List<BankAccountResponseDTO> getAllBankAccounts();
     void deleteBankAccount(String id);


}
