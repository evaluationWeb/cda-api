package com.adrar.api.dto;

import com.adrar.api.model.Book;

public class BookDTOWrapper {
    public static BookDTO wrapBookToBookDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getCreatedAt(),
                book.getAuthor().getFirstname() + "-"
                       + book.getAuthor().getLastname()
        );
    }
}
