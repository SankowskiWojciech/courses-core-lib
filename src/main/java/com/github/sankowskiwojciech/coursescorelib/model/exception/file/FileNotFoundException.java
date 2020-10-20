package com.github.sankowskiwojciech.coursescorelib.model.exception.file;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class FileNotFoundException extends DetailedException {
    private static final int STATUS_CODE = 404;
    private static final String ERROR_CODE = "FILE_NOT_FOUND";
    private static final String ERROR_MESSAGE = "File not found.";

    public FileNotFoundException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
