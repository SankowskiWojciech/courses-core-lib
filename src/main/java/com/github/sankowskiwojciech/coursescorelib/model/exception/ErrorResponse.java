package com.github.sankowskiwojciech.coursescorelib.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class ErrorResponse {
    private final int status;
    private final String errorCode;
    private final String errorMessage;
}
