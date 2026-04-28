package com.example.ordersbff.exception;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private int status;
    private String service;
}
