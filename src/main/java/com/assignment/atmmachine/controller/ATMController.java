package com.assignment.atmmachine.controller;

import com.assignment.atmmachine.model.Account;
import com.assignment.atmmachine.model.InvalidAccountException;
import com.assignment.atmmachine.model.InvalidPinException;
import com.assignment.atmmachine.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

@RestController
@RequestMapping("/atm")
public class ATMController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ATMController.class);
    private final AccountRepository accRep;

    // Initializing ATM Machine with notes
    private ArrayList<Integer> bank = new ArrayList();
    private HashMap<Integer, Integer> noteCounter = new HashMap<>();

    ATMController(AccountRepository accRep) {
        this.accRep = accRep;
    }

    @GetMapping("/accounts")
    public List<Account> all() {
        List list = new ArrayList();
        try {
            list = accRep.findAll();
        } catch(Exception e) {
            LOGGER.error("Error retrieving all accounts and their information. ", e.getMessage());
        }
        return list;
    }

    @GetMapping("/account/{accNumber}/{pin}/balance")
    public @ResponseBody Float getBalance(@PathVariable String accNumber, @PathVariable Integer pin) {
        Float balance = null;
        try {
            if(accRep.isAccountNumberExist(accNumber) == null) {
                throw new InvalidAccountException(accNumber);
            }

            balance = accRep.getBalance(accNumber, pin);

            if(balance == null) throw new InvalidPinException();
        } catch (Exception e) {
            LOGGER.error("Error retrieving balance for account " + accNumber, e.getMessage());
        }

        return balance;
    }

    //TODO: Still need to add logic for overdraft
    @RequestMapping("/withdraw/{accNumber}/{pin}/{amount}")
    public @ResponseBody String withdraw(@PathVariable String accNumber, @PathVariable Integer pin, @PathVariable float amount) {
        String result = "";
        try {
            if(hasEnoughNotes(amount)) { // first check if ATM has enough money to withdraw money
                Float balance = this.getBalance(accNumber, pin);
                if(balance >= amount) {
                    accRep.withdraw(accNumber, amount);
                    result = "Amount withdrawn: " + amount + " | New balance: " + this.getBalance(accNumber, pin);
                } else {
                    result = "Account did not have enough balance to withdraw " + amount;
                }
            }
        } catch(Exception e) {
            LOGGER.error("Error withdrawing money. Please try again.");
        }

        return result;
    }

    private void fillUpBank() {
        LOGGER.info("Initializing bank with money.");
        for(int i=0;i<10;i++) {
            bank.add(50);
        }
        for(int i=0;i<20;i++) {
            bank.add(5);
        }
        for(int i=0;i<30;i++) {
            bank.add(20);
        }
        for(int i=0;i<30;i++) {
            bank.add(10);
        }

        noteCounter.put(5,0);
        noteCounter.put(10,0);
        noteCounter.put(20,0);
        noteCounter.put(30,0);

        Collections.reverse(bank);
    }

    private boolean hasEnoughNotes(float amount) {
        // TODO: count notes that should add up to amount using greedy approach
        return true;
    }

}
