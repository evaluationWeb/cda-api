package com.adrar.api.service;

import com.adrar.api.exception.EmptyCategoryListException;
import com.adrar.api.model.Category;
import com.adrar.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    //Récupérer toutes les catégories
    public Iterable<Category> getAllCategories() {
        if(categoryRepository.count() == 0) {
            throw new EmptyCategoryListException("aucune categorie dans la BDD");
        }
        return categoryRepository.findAll();
    }
    //ajouter une categorie

    //récupérer une catégorie par son id

}
