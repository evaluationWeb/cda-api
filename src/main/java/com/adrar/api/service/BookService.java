package com.adrar.api.service;

import com.adrar.api.dto.BookDTO;
import com.adrar.api.dto.BookDTOWrapper;
import com.adrar.api.exception.BookEmptyListException;
import com.adrar.api.model.Book;
import com.adrar.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {
        if(bookRepository.count() == 0) {
            throw new BookEmptyListException("La liste des livres est vide");
        }
        return bookRepository.findAll();
    }

    public Iterable<BookDTO> getBooksDTO() {
        if(bookRepository.count() == 0) {
            throw new BookEmptyListException("La liste des livres est vide");
        }
        List<BookDTO> books = new ArrayList<>();
        for(Book book : bookRepository.findAll()) {
            books.add(BookDTOWrapper.wrapBookToBookDTO(book));
        }
       return books;
    }

    public Stream<BookDTO> getBooksDTOById(Long id) {
        return bookRepository.findById(id).stream().map(
                BookDTOWrapper::wrapBookToBookDTO);
    }
}
