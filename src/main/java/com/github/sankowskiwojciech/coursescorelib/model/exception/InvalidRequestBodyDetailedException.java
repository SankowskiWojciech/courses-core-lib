package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestBodyDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String ERROR_CODE = "INVALID_REQUEST_BODY";
    private static final String ERROR_MESSAGE = "Invalid request body.";

    public InvalidRequestBodyDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
