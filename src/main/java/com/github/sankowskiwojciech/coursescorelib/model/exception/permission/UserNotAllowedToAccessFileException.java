package com.github.sankowskiwojciech.coursescorelib.model.exception.permission;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class UserNotAllowedToAccessFileException extends DetailedException {
    private static final int STATUS_CODE = 403;
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_ACCESS_FILE";
    private static final String ERROR_MESSAGE = "User not allowed to access file.";

    public UserNotAllowedToAccessFileException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
