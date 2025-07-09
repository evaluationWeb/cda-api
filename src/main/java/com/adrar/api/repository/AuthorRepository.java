package com.adrar.api.repository;

import com.adrar.api.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    boolean existsByPseudo(String pseudo);
    boolean existsByPseudoAndFirstnameAndLastname(Author author);
    Author findAuthorByPseudo(String pseudo);
}
