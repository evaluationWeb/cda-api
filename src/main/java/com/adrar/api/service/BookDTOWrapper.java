package com.adrar.api.service;

import com.adrar.api.dto.BookDTO;
import com.adrar.api.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDTOWrapper {
    public BookDTO wrapBookToBookDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getCreatedAt(),
                book.getAuthor().getFirstname()  + "-"
                       + book.getAuthor().getLastname()
        );
    }
}
