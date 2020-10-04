package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundDetailedException extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.NOT_FOUND.value();
    private static final String ERROR_CODE = "STUDENT_NOT_FOUND";
    private static final String ERROR_MESSAGE = "Student with given id not found.";

    public StudentNotFoundDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
