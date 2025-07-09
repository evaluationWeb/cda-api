package com.adrar.api.exception.user;

public class EmptyUserListException extends RuntimeException {
    public EmptyUserListException(String message) {
        super(message);
    }
}
