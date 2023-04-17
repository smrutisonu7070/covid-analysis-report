package com.mindtree.exception;

public class InValidDateRangeException extends  RuntimeException{

    public InValidDateRangeException() {
        super("Invalid Date Range Exception");
    }

    public InValidDateRangeException(String message) {
        super(message);
    }
}
