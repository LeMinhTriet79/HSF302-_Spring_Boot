package com.example.smoking_swp.controller;


import com.example.smoking_swp.model.User;
import com.example.smoking_swp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello/{username}")
    public String hello(@PathVariable String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && userOpt.get().getFullName() != null) {
            return "Xin chào, " + userOpt.get().getFullName() + "!";
        } else {
            return "Xin chào, khách!";
        }
    }
}
