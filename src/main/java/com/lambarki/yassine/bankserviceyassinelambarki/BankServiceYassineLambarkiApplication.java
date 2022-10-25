package com.lambarki.yassine.bankserviceyassinelambarki;

import com.lambarki.yassine.bankserviceyassinelambarki.entities.BankAccount;
import com.lambarki.yassine.bankserviceyassinelambarki.entities.Customer;
import com.lambarki.yassine.bankserviceyassinelambarki.repositories.BankAccountRepository;
import com.lambarki.yassine.bankserviceyassinelambarki.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

import static com.lambarki.yassine.bankserviceyassinelambarki.enums.AccountType.CURRENT_ACCOUNT;
import static com.lambarki.yassine.bankserviceyassinelambarki.enums.AccountType.SAVING_ACCOUNT;
import static java.lang.Math.random;

@SpringBootApplication
public class BankServiceYassineLambarkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankServiceYassineLambarkiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {

            Stream.of("Mohamed", "Yassine", "Hanae", "Imane").forEach(
                    c->{
                        Customer customer = Customer.builder()
                                .name(c)
                                .build();
                        customerRepository.save(customer);
                    });

            customerRepository.findAll().forEach(customer -> {

                for (int i = 0; i < 10 ; i++) {
                    BankAccount bankAccount =
                            BankAccount
                                    .builder()
                                    .id(UUID.randomUUID().toString())
                                    .type(random()>0.5? CURRENT_ACCOUNT: SAVING_ACCOUNT)
                                    .balance(1000 + random() * 90000)
                                    .createdAt(LocalDate.now())
                                    .currency("MAD")
                                    .customer(customer)
                                    .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }
}
