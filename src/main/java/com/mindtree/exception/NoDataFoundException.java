package com.mindtree.exception;

public class NoDataFoundException extends  RuntimeException{

    public NoDataFoundException() {
        super("No data Found");
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
