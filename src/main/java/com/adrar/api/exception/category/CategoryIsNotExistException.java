package com.adrar.api.exception.category;

public class CategoryIsNotExistException extends RuntimeException {
    public CategoryIsNotExistException(String message) {
        super(message);
    }
}
