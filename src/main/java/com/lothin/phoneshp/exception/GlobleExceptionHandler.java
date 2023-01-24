package com.lothin.phoneshp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleExceptionClientError(ApiException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatus().getReasonPhrase(),e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(errorResponse);

    }
}
