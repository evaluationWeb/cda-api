package com.adrar.api.exception.author;

public class AuthorIsNotExistException extends RuntimeException {
    public AuthorIsNotExistException(String message) {
        super(message);
    }
}
