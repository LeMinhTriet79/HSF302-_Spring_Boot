package com.minhtriet.demo.controller;

import com.minhtriet.demo.dto.LoginRequest;
import com.minhtriet.demo.entity.User;
import com.minhtriet.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5177") // Cho phép React truy cập
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity getStudent() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.login(request.getEmail(), request.getPassword())
                .map(user -> ResponseEntity.ok().body("Đăng nhập thành công"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Email hoặc mật khẩu không đúng"));
    }
}
