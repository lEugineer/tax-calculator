package com.eugineer.taxcalc.exception;

public class EntityNotFoundException extends WebException {

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
