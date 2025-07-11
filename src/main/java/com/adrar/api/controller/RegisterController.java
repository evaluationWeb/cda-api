package com.adrar.api.controller;
import com.adrar.api.model.AuthRequest;
import com.adrar.api.model.User;
import com.adrar.api.service.JWTService;
import com.adrar.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    //Import des dépendances
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AuthenticationManager authenticationManager;

    //Méthode pour se connecter (avec un Json dans le body)
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                ));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authentication);
            Map<String, String> reponse = new HashMap<>();
            reponse.put("token", token);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(reponse);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    //Méthode pour créer un compte (avec un Json dans le body)
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> addNewUser(@RequestBody User userInfo) {
        String user = userInfoService.addUser(userInfo);
        Map<String,String> response = new HashMap<>();
        response.put("info", user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
