package com.assignment.atmmachine.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    private String accountNumber;
    @OneToOne @JoinColumn(name="contactid")
    private AccountHolder accountHolder;
    private int pinNumber;
    private Float balance;
    private Float overdraft;

    Account(String accNum, Contact contact, int pin, float balance, float overdraft) {
        this.accountNumber = accNum;
        accountHolder = (AccountHolder) contact;
        this.pinNumber = pin;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    Account() {}

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public String getAccountName() {
        return accountHolder.DisplayName();
    }

    public double getOverdraft() {
        return overdraft;
    }
}
