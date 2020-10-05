package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class InvalidBeginningOrEndLessonsDateDetailedException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "INVALID_SCHEDULED_LESSONS_DATES";
    private static final String ERROR_MESSAGE = "Beginning date or end date of scheduled lessons is invalid.";

    public InvalidBeginningOrEndLessonsDateDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
