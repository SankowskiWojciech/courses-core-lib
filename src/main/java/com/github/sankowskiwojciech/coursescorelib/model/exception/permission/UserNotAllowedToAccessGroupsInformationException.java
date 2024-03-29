package com.github.sankowskiwojciech.coursescorelib.model.exception.permission;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class UserNotAllowedToAccessGroupsInformationException extends DetailedException {
    private static final int STATUS_CODE = 403;
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_ACCESS_GROUPS_INFORMATION";
    private static final String ERROR_MESSAGE = "User is not allowed to access information about groups.";

    public UserNotAllowedToAccessGroupsInformationException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
