package com.example.demo.controller.exception;

public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {

    public MobileNumberDoesNotExistsForEmployeeException(String message) {
        super(message);
    }
}