package com.adrar.api.exception.author;

public class AuthorExistException extends RuntimeException {
    public AuthorExistException( String message) {
        super(message);
    }
}
