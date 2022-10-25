package com.lambarki.yassine.bankserviceyassinelambarki.repositories;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
