package com.lothin.phoneshp.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleExceptionClientError(ApiException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatus().getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(errorResponse);

    }
}
