package com.example.coursemanager.exception;

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException (String message){
        super(message);
    }
}
