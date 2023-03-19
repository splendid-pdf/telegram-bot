package com.github.splendidpdf.exception;

public class EntityAlreadyExistsException extends Exception {

    @Override
    public String getMessage() {
        return "Entity already exist";
    }
}