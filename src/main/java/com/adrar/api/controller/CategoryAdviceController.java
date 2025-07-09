package com.adrar.api.controller;

import com.adrar.api.exception.category.CategoryExistException;
import com.adrar.api.exception.category.CategoryIsNotExistException;
import com.adrar.api.exception.category.EmptyCategoryListException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CategoryAdviceController {

    @ExceptionHandler(CategoryExistException.class)
    public ResponseEntity<Map<String, String>> handlerCategoryExistException(CategoryExistException ex) {
        return getMapResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryIsNotExistException.class)
    public ResponseEntity<Map<String, String>> handlerCategoryIsExistException(CategoryIsNotExistException ex) {
        return getMapResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyCategoryListException.class)
    public ResponseEntity<Map<String, String>> handlerEmptyCategoryListException(EmptyCategoryListException ex) {
        return getMapResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private static @NotNull ResponseEntity<Map<String, String>> getMapResponseEntity(String ex, HttpStatus notFound) {
        Map<String, String> reponse = new HashMap<>();
        reponse.put("Error", ex);
        return ResponseEntity
                .status(notFound)
                .body(reponse);
    }
}
