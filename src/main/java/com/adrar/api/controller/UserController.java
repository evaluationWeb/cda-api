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
    public ResponseEntity<User> createUser(@NotNull @RequestBody User user) {
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
    public ResponseEntity<Optional<User>> findUserById(@PathVariable @NotNull Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(user)
                );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateFirstnameAndLastnameUserById(@RequestBody User user, @PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUserFirstnameAndLastname(user, id));
    }

    @PatchMapping("/v2/{id}")
    public ResponseEntity<User> updateEmailUserById(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUserEmail(user.getEmail(),id)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        boolean delete = userService.deleteUserById(id);
        String message = "";
        if(delete) {
            message = "Supprimé";
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }
}
