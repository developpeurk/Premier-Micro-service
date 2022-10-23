package com.lambarki.yassine.bankserviceyassinelambarki.repositories;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
