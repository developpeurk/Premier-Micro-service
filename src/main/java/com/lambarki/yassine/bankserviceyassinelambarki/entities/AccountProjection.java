package com.lambarki.yassine.bankserviceyassinelambarki.entities;

import com.lambarki.yassine.bankserviceyassinelambarki.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name="p1")
public interface AccountProjection {

     String getId();
     AccountType getType();
     Double getBalance();

}
