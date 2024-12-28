package com.swagthehooman.chatapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.swagthehooman.chatapplication.Repositories.IUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepo;

    @GetMapping("/prefixuser")
    public List<String> getUserByPrefix(@RequestParam String prefix) {
        return userRepo.findUsernameByPrefix(prefix);
    }

}
