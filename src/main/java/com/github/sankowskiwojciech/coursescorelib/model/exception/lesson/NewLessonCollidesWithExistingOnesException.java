package com.github.sankowskiwojciech.coursescorelib.model.exception.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class NewLessonCollidesWithExistingOnesException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "LESSONS_DATES_COLLISION";
    private static final String ERROR_MESSAGE = "Dates of lesson collide with existing lessons.";

    public NewLessonCollidesWithExistingOnesException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
