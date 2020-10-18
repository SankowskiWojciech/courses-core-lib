package com.github.sankowskiwojciech.coursescorelib.model.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
enum ErrorMessages {
    FILE_SIZE_EXCEEDED("File size exceeded.");

    private final String errorMessage;
}
