package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class InvalidLessonsDurationDetailedException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "INVALID_SCHEDULED_LESSONS_DURATION";
    private static final String ERROR_MESSAGE = "Scheduled duration in minutes is invalid.";

    public InvalidLessonsDurationDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
