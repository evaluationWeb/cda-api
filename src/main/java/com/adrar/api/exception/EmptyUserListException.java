package com.adrar.api.exception;

public class EmptyUserListException extends RuntimeException {
    public EmptyUserListException(String message) {
        super(message);
    }
}
