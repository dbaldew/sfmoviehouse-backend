package com.ticketapp.sfmoviehouse.exception;

import java.io.Serial;

public class InvalidPassWordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidPassWordException(String message) {
        super(message);
    }
    public InvalidPassWordException() {
        super("Invalid password.");
    }
}