package com.assignment.atmmachine.model;

public class InvalidPinException extends RuntimeException {

    public InvalidPinException() {
        super("Incorrect pin. Plese try again.");
    }
}
