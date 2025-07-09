package com.adrar.api.exception;

public class AuthorIsNotExistException extends RuntimeException {
    public AuthorIsNotExistException(String message) {
        super(message);
    }
}
