package com.dev.backend.entities.Exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(String message){
        super(message);
    }
    
}
