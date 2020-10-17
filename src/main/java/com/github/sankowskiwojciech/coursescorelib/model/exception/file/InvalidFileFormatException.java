package com.github.sankowskiwojciech.coursescorelib.model.exception.file;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class InvalidFileFormatException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "INVALID_FILE_FORMAT";
    private static final String ERROR_MESSAGE = "File format is invalid.";

    public InvalidFileFormatException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
