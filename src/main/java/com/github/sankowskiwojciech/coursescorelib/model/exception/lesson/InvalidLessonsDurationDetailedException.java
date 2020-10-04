package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;
import org.springframework.http.HttpStatus;

public class InvalidLessonsDurationDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String ERROR_CODE = "INVALID_SCHEDULED_LESSONS_DURATION";
    private static final String ERROR_MESSAGE = "Scheduled duration in minutes is invalid.";

    public InvalidLessonsDurationDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
