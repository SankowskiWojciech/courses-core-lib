package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class UserNotAllowedToAccessSubdomainDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.FORBIDDEN.value();
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_ACCESS_SUBDOMAIN";
    private static final String ERROR_MESSAGE = "User not allowed to access subdomain.";

    public UserNotAllowedToAccessSubdomainDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
