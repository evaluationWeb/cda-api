package com.adrar.api.controller;

import com.adrar.api.model.Category;
import com.adrar.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.addCategory(category.getName()));
    }
}
