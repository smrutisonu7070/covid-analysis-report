package com.mindtree.exception;

public class InvalidStateCodeException extends RuntimeException{

    public InvalidStateCodeException() {

        super("Invalid State Code, Please put Valid Input");
    }

    public InvalidStateCodeException(String message) {
        super(message);
    }
}
