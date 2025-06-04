package com.minhtriet.appswp.controller;

import com.minhtriet.appswp.entity.User;
import com.minhtriet.appswp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

    @Autowired
    private UserService userService;

    // API Đăng ký
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Kiểm tra email đã tồn tại chưa
            if (userService.isEmailExists(request.getEmail())) {
                response.put("success", false);
                response.put("message", "Email đã được sử dụng");
                return ResponseEntity.badRequest().body(response);
            }

            // Kiểm tra mật khẩu và xác nhận mật khẩu
            if (!request.getPassword().equals(request.getConfirmPassword())) {
                response.put("success", false);
                response.put("message", "Mật khẩu xác nhận không khớp");
                return ResponseEntity.badRequest().body(response);
            }

            // Tạo user mới
            User newUser = new User();
            newUser.setFullName(request.getFullName());
            newUser.setEmail(request.getEmail());
            newUser.setPasswordHash(request.getPassword()); // Trong thực tế nên hash password
            newUser.setUsername(request.getEmail()); // Dùng email làm username
            newUser.setRole("member");

            User savedUser = userService.createNewUser(newUser);

            response.put("success", true);
            response.put("message", "Đăng ký thành công");
            response.put("user", Map.of(
                    "id", savedUser.getUserId(),
                    "fullName", savedUser.getFullName(),
                    "email", savedUser.getEmail(),
                    "role", savedUser.getRole()
            ));

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Đăng ký thất bại: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // API Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Tìm user theo email
            User user = userService.getUserByEmail(request.getEmail());

            if (user == null) {
                response.put("success", false);
                response.put("message", "Email không tồn tại");
                return ResponseEntity.badRequest().body(response);
            }

            // Kiểm tra mật khẩu (trong thực tế nên so sánh hash)
            if (!user.getPasswordHash().equals(request.getPassword())) {
                response.put("success", false);
                response.put("message", "Mật khẩu không đúng");
                return ResponseEntity.badRequest().body(response);
            }

            // Cập nhật thời gian đăng nhập cuối
            userService.updateLastLoginDate(user.getUserId());

            response.put("success", true);
            response.put("message", "Đăng nhập thành công");
            response.put("user", Map.of(
                    "id", user.getUserId(),
                    "fullName", user.getFullName(),
                    "email", user.getEmail(),
                    "role", user.getRole(),
                    "profilePictureUrl", user.getProfilePictureUrl() != null ? user.getProfilePictureUrl() : ""
            ));

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Đăng nhập thất bại: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Class cho request đăng ký
    public static class RegisterRequest {
        private String fullName;
        private String email;
        private String password;
        private String confirmPassword;

        // Constructors
        public RegisterRequest() {}

        // Getters and Setters
        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public String getConfirmPassword() { return confirmPassword; }
        public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
    }

    // Class cho request đăng nhập
    public static class LoginRequest {
        private String email;
        private String password;

        // Constructors
        public LoginRequest() {}

        // Getters and Setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}