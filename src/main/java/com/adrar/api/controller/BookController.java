package com.adrar.api.controller;

import com.adrar.api.dto.BookDTO;
import com.adrar.api.model.Book;
import com.adrar.api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> findAllBooks() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getAllBooks());
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<BookDTO>> findAllBooksDTO() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getBooksDTO());
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.addBook(book));
    }
}
