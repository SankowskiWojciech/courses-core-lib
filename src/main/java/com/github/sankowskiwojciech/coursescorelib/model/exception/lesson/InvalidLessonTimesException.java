package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class InvalidLessonTimesException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "INVALID_LESSON_TIMES";
    private static final String ERROR_MESSAGE = "Start time or end time of lesson is invalid.";

    public InvalidLessonTimesException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
