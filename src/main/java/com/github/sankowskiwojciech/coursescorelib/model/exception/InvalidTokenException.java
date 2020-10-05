package com.github.sankowskiwojciech.coursescorelib.model.exception;

public class InvalidTokenException extends DetailedException {
    private static final int STATUS_CODE = 401;
    private static final String ERROR_CODE = "INVALID_TOKEN";
    private static final String ERROR_MESSAGE = "Token is invalid.";

    public InvalidTokenException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
