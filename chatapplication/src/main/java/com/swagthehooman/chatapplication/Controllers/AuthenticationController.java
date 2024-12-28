package com.swagthehooman.chatapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagthehooman.chatapplication.DTOs.UserAuthDTO;
import com.swagthehooman.chatapplication.DTOs.UserLoginDTO;
import com.swagthehooman.chatapplication.DTOs.UserRegisterDTO;
import com.swagthehooman.chatapplication.services.AuthenticationServices.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserAuthDTO register(@RequestBody UserRegisterDTO userRegister) {
        return authenticationService.registerUser(userRegister);
    }

    @PostMapping("/login")
    public UserAuthDTO login(@RequestBody UserLoginDTO userLogin) {
        return authenticationService.loginUser(userLogin);
    }

}
