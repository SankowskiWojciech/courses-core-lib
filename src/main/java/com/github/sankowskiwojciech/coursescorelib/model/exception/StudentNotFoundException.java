package com.github.sankowskiwojciech.coursescorelib.model.exception;

public class StudentNotFoundException extends DetailedException {
    private static final int STATUS_CODE = 404;
    private static final String ERROR_CODE = "STUDENT_NOT_FOUND";
    private static final String ERROR_MESSAGE = "Student with given id not found.";

    public StudentNotFoundException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
