package com.github.sankowskiwojciech.coursescorelib.model.exception.group;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class GroupNotFoundException extends DetailedException {
    private static final int STATUS_CODE = 404;
    private static final String ERROR_CODE = "GROUP_NOT_FOUND";
    private static final String ERROR_MESSAGE = "Group not found.";

    public GroupNotFoundException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
