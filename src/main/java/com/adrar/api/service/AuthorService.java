package com.adrar.api.service;

import com.adrar.api.exception.AuthorEmptyListException;
import com.adrar.api.exception.AuthorExistException;
import com.adrar.api.exception.AuthorIsNotExistException;
import com.adrar.api.model.Author;
import com.adrar.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author){
        if (authorRepository.existsByPseudo(author.getPseudo())){
            throw new AuthorExistException("l'auteur existe déja");
        }
        return authorRepository.save(author);
    }

    public Iterable<Author> getAllAuthor(){
        if(authorRepository.count() == 0){
            throw new AuthorEmptyListException("La liste des auteurs est vide");
        }
        return authorRepository.findAll();
    }

    public Author getAuthorByPseudo(String pseudo){
        if(!authorRepository.existsByPseudo(pseudo)){
            throw new AuthorIsNotExistException("l'auteur n'existe pas");
        }
        return authorRepository.findAuthorByPseudo(pseudo);
    }
}
