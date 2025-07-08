package com.adrar.api.controller;

import com.adrar.api.model.User;
import com.adrar.api.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Ajouter un utilisateur
    @PostMapping
    public ResponseEntity<User> saveUser(@NotNull @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(user)
                );
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id).get());
    }

}
