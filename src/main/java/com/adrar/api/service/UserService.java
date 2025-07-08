package com.adrar.api.service;

import com.adrar.api.model.User;
import com.adrar.api.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //ajout
    public User addUser(@NotNull User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Le compte existe déja");
        }
        return userRepository.save(user);
    }

    //mettre à jour
    public User updateUser(@NotNull User user) {
        if (!getUserByEmail(user.getEmail())) {
            throw new RuntimeException("Le compte n'existe pas");
        }
        return userRepository.save(user);
    }

    //récupérer par id
    public Optional<User> getUserById(@NotNull Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Le compte n'existe pas");
        }
        return userRepository.findById(id);
    }

    //récupérer tous
    public Iterable<User> getAllUser() {
        if (userRepository.count() == 0) {
            throw new RuntimeException("la liste est vide");
        }
        return userRepository.findAll();
    }

    //récupérer par email
    public boolean getUserByEmail(@NotNull String email) {
        return userRepository.existsByEmail(email);
    }

    //supprimer
    public boolean deleteUserById(@NotNull Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Le compte n'existe pas");
        }
        userRepository.deleteById(id);
        return true;
    }

    public User updateUserFirstnameAndLastname(@NotNull User user, @NotNull Integer id) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser.equals(null)) {
            throw new RuntimeException("Le compte n'existe pas");
        }
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        return userRepository.save(updatedUser);
    }

    public User updateUserEmail(@NotNull String email, @NotNull Integer id) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser.equals(null)) {
            throw new RuntimeException("Le compte n'existe pas");
        }
        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email déja utilisé");
        }
        updatedUser.setEmail(email);
        return userRepository.save(updatedUser);
    }
}
