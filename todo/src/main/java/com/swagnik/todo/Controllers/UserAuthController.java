package com.swagnik.todo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagnik.todo.DTOs.UserCredentialsDTO;
import com.swagnik.todo.Services.AuthenticationService.AuthenticationService;
import com.swagnik.todo.DTOs.UserAuthDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserCredentialsDTO> signup(@RequestBody UserAuthDTO loginCredentials) {
        UserCredentialsDTO userDetails = null;
        try {
            userDetails = authenticationService.createUser(loginCredentials);
            return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(userDetails, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserCredentialsDTO> login(@RequestBody UserAuthDTO loginCredentials) {
        UserCredentialsDTO userDetails = null;
        try {
            userDetails = authenticationService.createUser(loginCredentials);
            return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(userDetails, HttpStatus.UNAUTHORIZED);
        }
    }

}
