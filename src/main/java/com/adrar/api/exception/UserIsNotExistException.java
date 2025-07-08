package com.adrar.api.exception;

public class UserIsNotExistException extends RuntimeException {
    public UserIsNotExistException(String message) {
        super(message);
    }
}
