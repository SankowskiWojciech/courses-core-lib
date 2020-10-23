package com.github.sankowskiwojciech.coursescorelib.model.exception.permission;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class UserNotAllowedToReadFileException extends DetailedException {
    private static final int STATUS_CODE = 403;
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_READ_FILE";
    private static final String ERROR_MESSAGE = "User not allowed to read file.";

    public UserNotAllowedToReadFileException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
