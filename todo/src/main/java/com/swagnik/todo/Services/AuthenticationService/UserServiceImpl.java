package com.swagnik.todo.Services.AuthenticationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swagnik.todo.Models.User;
import com.swagnik.todo.Repositories.IUserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        List<User> userData = userRepository.findByEmail(userEmail);
        if (userData.isEmpty())
            throw new UsernameNotFoundException(userEmail + "not found");
        return new UserDetailsImpl(userData.get(0));
    }

}
