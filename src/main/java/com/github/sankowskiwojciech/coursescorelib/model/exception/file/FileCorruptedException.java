package com.github.sankowskiwojciech.coursescorelib.model.exception.file;

import com.github.sankowskiwojciech.coursescorelib.model.exception.DetailedException;

public class FileCorruptedException extends DetailedException {
    private static final int STATUS_CODE = 400;
    private static final String ERROR_CODE = "FILE_CORRUPTED";
    private static final String ERROR_MESSAGE = "File is corrupted.";

    public FileCorruptedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
