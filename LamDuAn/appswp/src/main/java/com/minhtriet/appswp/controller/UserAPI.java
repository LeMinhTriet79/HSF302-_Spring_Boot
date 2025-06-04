package com.minhtriet.appswp.controller;

import com.minhtriet.appswp.entity.User;
import com.minhtriet.appswp.repository.UserRepository;
import com.minhtriet.appswp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Nơi tiếp nhận các request...
public class UserAPI {

    // LƯU Ý: Controller này dành cho ADMIN quản lý users
    // Không dành cho đăng nhập/đăng ký (dùng AuthAPI)

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

    // Lấy tất cả users - CHỈ ADMIN mới được dùng
    @GetMapping("/api/user")
    public ResponseEntity getUser() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Lấy user theo ID - CHỈ ADMIN hoặc chính user đó
    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tạo user mới - CHỈ ADMIN (user thường dùng /api/auth/register)
    @PostMapping("/api/user")
    public ResponseEntity createNewUser(@Valid @RequestBody User user) {
        // KIỂM TRA email đã tồn tại chưa
        if (userService.isEmailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email đã được sử dụng");
        }

        User newUser = userService.createNewUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Cập nhật user - CHỈ ADMIN hoặc chính user đó
    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUserById(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa user - CHỈ ADMIN
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CÁC ENDPOINT ĐẶC BIỆT - CHỈ ADMIN

    // Tìm user theo username
    @GetMapping("/api/user/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm user theo email
    @GetMapping("/api/user/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lấy users theo role
    @GetMapping("/api/user/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }

    // Lấy users có coach
    @GetMapping("/api/user/with-coach")
    public ResponseEntity<List<User>> getUsersWithCoach() {
        List<User> users = userService.getUsersWithCoach();
        return ResponseEntity.ok(users);
    }

    // Lấy users theo coach ID
    @GetMapping("/api/user/coach/{coachId}")
    public ResponseEntity<List<User>> getUsersByCoachId(@PathVariable Long coachId) {
        List<User> users = userService.getUsersByCoachId(coachId);
        return ResponseEntity.ok(users);
    }

    //Controller --> nhận điều hướng request
    //service --> xử lý logic
}