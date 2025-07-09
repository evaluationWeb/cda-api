package com.adrar.api.controller;

import com.adrar.api.model.Author;
import com.adrar.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Repository
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.addAuthor(author));
    }

    @GetMapping
    public ResponseEntity<Iterable<Author>> findAllAuthors(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getAllAuthor());
    }

    @GetMapping("/pseudo")
    public ResponseEntity<Author> findAllAuthorsPseudo(@RequestBody Author author){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getAuthorByPseudo(author.getPseudo()));
    }
}
