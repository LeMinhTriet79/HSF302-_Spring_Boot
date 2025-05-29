package com.example.smoking_swp.controller;

import com.example.smoking_swp.model.User;
import com.example.smoking_swp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User loggedIn = userService.login(user.getUsername(), user.getPasswordHash());
        if (loggedIn == null) throw new RuntimeException("Login failed");
        return loggedIn;
    }
}
