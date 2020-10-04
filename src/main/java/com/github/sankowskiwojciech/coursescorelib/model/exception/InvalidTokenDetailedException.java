package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.UNAUTHORIZED.value();
    private static final String ERROR_CODE = "INVALID_TOKEN";
    private static final String ERROR_MESSAGE = "Token is invalid.";

    public InvalidTokenDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
