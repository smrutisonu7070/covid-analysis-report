package com.mindtree.exception;

public class InvalidDateException extends RuntimeException{

    public InvalidDateException() {
        super("Invalid Date");
    }

    public InvalidDateException(String message) {
        super(message);
    }
}
