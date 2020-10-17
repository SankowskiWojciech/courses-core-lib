package com.github.sankowskiwojciech.coursescorelib.model.exception.permission;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class UserNotAllowedToCreateFileException extends DetailedException {
    private static final int STATUS_CODE = 403;
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_CREATE_FILES";
    private static final String ERROR_MESSAGE = "User not allowed to create files.";

    public UserNotAllowedToCreateFileException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
