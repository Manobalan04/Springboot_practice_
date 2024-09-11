package com.example.re.remain.controller;

public class StudentNameAlreadyExistsException extends RuntimeException {
    public StudentNameAlreadyExistsException(String message) {
        super(message);
    }
}
