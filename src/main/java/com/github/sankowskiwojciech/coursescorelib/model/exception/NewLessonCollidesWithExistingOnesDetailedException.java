package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class NewLessonCollidesWithExistingOnesDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String ERROR_CODE = "LESSONS_DATES_COLLISION";
    private static final String ERROR_MESSAGE = "Dates of lesson collide with existing lessons.";

    public NewLessonCollidesWithExistingOnesDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
