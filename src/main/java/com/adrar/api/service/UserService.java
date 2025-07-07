package com.adrar.api.service;

import com.adrar.api.model.User;
import com.adrar.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //ajout
    public User addUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Le compte existe déja");
        }
        return userRepository.save(user);
    }

    //mettre à jour

    //récupérer par id

    //récupérer tous

    //récupérer par email
    public boolean getUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    //supprimer
}
