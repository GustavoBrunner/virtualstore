package com.dev.backend.entities.Exceptions;

public class InvalidCpfException extends Exception{
    public InvalidCpfException(String message) {
        super(message);
    }
}
