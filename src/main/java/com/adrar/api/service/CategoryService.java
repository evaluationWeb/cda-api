package com.adrar.api.service;

import com.adrar.api.exception.CategoryExistException;
import com.adrar.api.exception.CategoryIsNotExistException;
import com.adrar.api.exception.EmptyCategoryListException;
import com.adrar.api.model.Category;
import com.adrar.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Category addCategory(String name) {
        if(categoryRepository.existsByName(name)) {
            throw new CategoryExistException("la catégory existe déja");
        }
        Category category = new Category(name);
        return categoryRepository.save(category);
    }
    //récupérer une catégorie par son id
    public Optional<Category> getCategoryById(Long id) {
        if(!categoryRepository.existsById(id)) {
            throw new CategoryIsNotExistException("La catégory n'existe pas");
        }
        return categoryRepository.findById(id);
    }
}
