package com.github.sankowskiwojciech.coursescorelib.model.exception.permission;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class UserNotAllowedToCreateLessonException extends DetailedException {
    private static final int STATUS_CODE = 403;
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_CREATE_LESSONS";
    private static final String ERROR_MESSAGE = "User not allowed to create lessons.";

    public UserNotAllowedToCreateLessonException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
