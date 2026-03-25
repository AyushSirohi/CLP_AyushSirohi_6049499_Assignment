package com.example.demo.controller.exception;

public class DepartmentNameNotFoundException extends RuntimeException {

    public DepartmentNameNotFoundException(String message) {
        super(message);
    }
}