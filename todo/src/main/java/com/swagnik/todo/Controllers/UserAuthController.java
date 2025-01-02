package com.swagnik.todo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagnik.todo.DTOs.UserCredentialsDTO;
import com.swagnik.todo.DTOs.UserAuthDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    // @PostMapping("/login")
    // public ResponseEntity<UserCredentialsDTO> loginAuth(@RequestBody UserLoginDTO
    // loginCredentials) {

    // }

}
