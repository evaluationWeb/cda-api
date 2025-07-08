package com.adrar.api.controller;

import com.adrar.api.exception.UserExistException;
import com.adrar.api.exception.UserIsNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserAdviceController {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Map<String, String>> handleUserExistException(UserExistException ex) {
        Map response = new HashMap();
        response.put("Error", ex.getMessage());
        response.put("Status Code ", String.valueOf(HttpStatus.CONFLICT.value()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UserIsNotExistException.class)
    public ResponseEntity<Map<String, String>> handleUserIsNotExistException(UserIsNotExistException ex) {
    Map response = new HashMap();
    response.put("Error", ex.getMessage());
    response.put("Status Code ", String.valueOf(HttpStatus.NOT_FOUND.value()));
    return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
