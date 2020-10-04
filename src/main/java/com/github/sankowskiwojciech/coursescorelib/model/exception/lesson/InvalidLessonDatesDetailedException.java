package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;
import org.springframework.http.HttpStatus;

public class InvalidLessonDatesDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String ERROR_CODE = "INVALID_LESSON_DATES";
    private static final String ERROR_MESSAGE = "Start date or end date of lesson is invalid.";

    public InvalidLessonDatesDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
