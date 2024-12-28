package com.swagthehooman.chatapplication.services.AuthenticationServices;

import java.util.HashSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swagthehooman.chatapplication.DTOs.UserAuthDTO;
import com.swagthehooman.chatapplication.DTOs.UserLoginDTO;
import com.swagthehooman.chatapplication.DTOs.UserRegisterDTO;
import com.swagthehooman.chatapplication.Models.User;
import com.swagthehooman.chatapplication.Repositories.IUserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepo;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    public UserAuthDTO registerUser(UserRegisterDTO userInfo) {
        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setUserId(UUID.randomUUID());
        user.setIsActive(true);
        user.setRoles(userInfo.getRoles());
        user.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        userRepo.save(user);
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword()));
        String token = tokenService.generateJwt(auth);

        return new UserAuthDTO(user, token);
    }

    public UserAuthDTO loginUser(UserLoginDTO userLogin) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
            System.out.println(auth);
            String token = tokenService.generateJwt(auth);
            return new UserAuthDTO(userRepo.findByUsername(userLogin.getUsername()).get(), token);
        } catch (Exception e) {
            e.printStackTrace();
            return new UserAuthDTO(null, "");
        }
    }
}
