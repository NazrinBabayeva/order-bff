package com.example.ordersbff.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex) {

        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setStatus(404);
        error.setService("order-ms");

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex) {

        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setStatus(400);
        error.setService("order-ms");

        return ResponseEntity.status(400).body(error);
    }
}
