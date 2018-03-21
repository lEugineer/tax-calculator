package com.eugineer.taxcalc.exception;

public class WebException extends RuntimeException {
    public int status;

    public WebException(String message, int status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public WebException(String message, int status) {
        super(message);
        this.status = status;
    }

    public WebException(String message, Throwable cause) {
        this(message, 400, cause);
    }

    public WebException(String message) {
        this(message, 400);
    }
}
