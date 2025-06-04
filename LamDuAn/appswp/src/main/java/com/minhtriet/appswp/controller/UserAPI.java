package com.minhtriet.appswp.controller;

import com.minhtriet.appswp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class UserAPI {

    //LẤY LÀ GET
    //GET: /api/user

    //POST ~ CREATE NEW
    //POST: /api/user

    //PUT ~ UPDATE
    //PUT: /api/user/id --> cần phải biết cái nào, ai, thông qua id
    //PATCH ---> Cập nhật một trường nào đó cụ thể

    //DELETE
    //DELETE: /api/user/id
    //--> nó giống PUT ~ UPDATE, cần phải chỉ rõ cụ thể, đâu đó rõ ràng, không có nói chung chung

    //ORM
    //Controller --> service --> repo

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity getUser() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/user")
    public ResponseEntity createNewUser(@Valid @RequestBody User user) {
        User newUser = userService.createNewUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Integer id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUserById(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Thêm một số endpoint đặc biệt cho User
    @GetMapping("/api/user/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/user/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/user/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }

    //Controller --> nhận điều hướng request
    //service --> xử lý logic
}