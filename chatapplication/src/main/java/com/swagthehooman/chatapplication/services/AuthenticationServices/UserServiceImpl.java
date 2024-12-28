package com.swagthehooman.chatapplication.services.AuthenticationServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swagthehooman.chatapplication.Models.User;
import com.swagthehooman.chatapplication.Repositories.IUserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        System.out.println("user = " + user.get());
        user.orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
        return user.map(UserDetailsImpl::new).get();
    }

}
