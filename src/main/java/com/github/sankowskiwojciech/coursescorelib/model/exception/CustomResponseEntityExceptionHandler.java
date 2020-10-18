package com.github.sankowskiwojciech.coursescorelib.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DetailedException.class)
    public ResponseEntity<Object> handleDetailedException(DetailedException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getStatusCode(), exception.getErrorCode(), exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getStatusCode()));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exception) {
        final HttpStatus payloadTooLargeErrorCode = HttpStatus.PAYLOAD_TOO_LARGE;
        ErrorResponse errorResponse = new ErrorResponse(payloadTooLargeErrorCode.value(), ErrorCodes.FILE_SIZE_EXCEEDED.name(), ErrorMessages.FILE_SIZE_EXCEEDED.getErrorMessage());
        return new ResponseEntity<>(errorResponse, payloadTooLargeErrorCode);
    }
}
