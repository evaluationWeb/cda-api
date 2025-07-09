package com.adrar.api.exception;

public class CategoryIsNotExistException extends RuntimeException {
    public CategoryIsNotExistException(String message) {
        super(message);
    }
}
