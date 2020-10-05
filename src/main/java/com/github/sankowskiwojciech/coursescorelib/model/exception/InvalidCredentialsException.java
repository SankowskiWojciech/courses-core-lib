package com.github.sankowskiwojciech.coursescorelib.model.exception;

public class InvalidCredentialsException extends DetailedException {
    private static final int STATUS_CODE = 401;
    private static final String ERROR_CODE = "INVALID_CREDENTIALS";
    private static final String ERROR_MESSAGE = "Address email or password is incorrect.";

    public InvalidCredentialsException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
