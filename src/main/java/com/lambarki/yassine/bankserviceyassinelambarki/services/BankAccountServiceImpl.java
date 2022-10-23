package com.lambarki.yassine.bankserviceyassinelambarki.services;

import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountRequestDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.dtos.BankAccountResponseDTO;
import com.lambarki.yassine.bankserviceyassinelambarki.entities.BankAccount;
import com.lambarki.yassine.bankserviceyassinelambarki.mappers.BankAccountMapper;
import com.lambarki.yassine.bankserviceyassinelambarki.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountResponseDTO save(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO getBankAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        return bankAccountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public BankAccountResponseDTO update(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountRequestDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOS =
                bankAccounts
                        .stream()
                        .map(
                        bankAccount -> bankAccountMapper.fromBankAccount(bankAccount))
                        .collect(Collectors.toList());
        return bankAccountResponseDTOS;

    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);

    }
}
