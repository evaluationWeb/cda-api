package com.adrar.api.exception;

import org.springframework.http.HttpStatus;

public class AuthorExistException extends RuntimeException {
    public AuthorExistException( String message) {
        super(message);
    }
}
