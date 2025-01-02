package com.swagnik.todo.Services.AuthenticationService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swagnik.todo.DTOs.UserAuthDTO;
import com.swagnik.todo.DTOs.UserCredentialsDTO;
import com.swagnik.todo.Models.Role;
import com.swagnik.todo.Models.User;
import com.swagnik.todo.Repositories.IUserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserCredentialsDTO createUser(UserAuthDTO authDetails) {
        User user = new User();
        user.setEmail(authDetails.getEmail());
        user.setUsername(authDetails.getUsername());
        user.setPassword(encoder.encode(authDetails.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        user.setRoles(roles);

        user = userRepository.save(user);

        return new UserCredentialsDTO();

    }

    private String generateJWTForUser(String email, String password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        return "";
    }
}
