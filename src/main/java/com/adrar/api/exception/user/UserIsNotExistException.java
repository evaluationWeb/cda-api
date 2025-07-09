package com.adrar.api.exception.user;

public class UserIsNotExistException extends RuntimeException {
    public UserIsNotExistException(String message) {
        super(message);
    }
}
