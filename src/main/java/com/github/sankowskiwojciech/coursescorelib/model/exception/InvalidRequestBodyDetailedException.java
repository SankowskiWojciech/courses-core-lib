package com.github.sankowskiwojciech.coursescorelib.model.exception;

public class InvalidRequestBodyDetailedException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "INVALID_REQUEST_BODY";
    private static final String ERROR_MESSAGE = "Invalid request body.";

    public InvalidRequestBodyDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
