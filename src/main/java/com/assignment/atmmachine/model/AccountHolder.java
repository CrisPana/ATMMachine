package com.assignment.atmmachine.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class AccountHolder extends Contact {

    AccountHolder(String firstName, String lastName, String phoneNumber, Date dob, Address addr) {
        super(firstName, lastName, phoneNumber, dob, addr);
    }

    AccountHolder() {

    }
}
