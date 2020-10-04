package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;

public class UserNotAllowedToReadInformationAboutStudents extends DetailedException {
    private static final int STATUS_CODE = HttpStatus.FORBIDDEN.value();
    private static final String ERROR_CODE = "USER_NOT_ALLOWED_TO_ACCESS_STUDENTS_INFORMATION";
    private static final String ERROR_MESSAGE = "User is not allowed to access information about students.";

    public UserNotAllowedToReadInformationAboutStudents() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
