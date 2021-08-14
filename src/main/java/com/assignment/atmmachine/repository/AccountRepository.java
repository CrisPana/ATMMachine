package com.assignment.atmmachine.repository;

import com.assignment.atmmachine.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/*
* Class to allows us to communicate with database regarding account entity
* */
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "select acc.balance from Account acc where acc.accountNumber = :accNumber and acc.pinNumber = :pin")
    Float getBalance(@Param("accNumber") String accNumber, @Param("pin") Integer pin);

    // TODO: Add lilmit here to only should retireve at most one result as we cannot have the accounts with same account number
    @Query(value = "select acc from Account acc where acc.accountNumber = :accNumber")
    Account isAccountNumberExist(@Param("accNumber") String accNum);

    @Transactional
    @Modifying
    @Query(value = "update Account acc set acc.balance = acc.balance - :amount where acc.accountNumber = :accNumber")
    void withdraw(@Param("accNumber") String accNumber, @Param("amount") float amount);

}
