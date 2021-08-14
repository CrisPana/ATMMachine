package com.assignment.atmmachine.model;

public class InvalidAccountException extends RuntimeException {

    public InvalidAccountException(String accNumber) {
        super("Invalid account: " + accNumber);
    }
}
