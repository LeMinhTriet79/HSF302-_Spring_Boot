package com.minhtriet.appswp.service;

import com.minhtriet.appswp.entity.User;
import com.minhtriet.appswp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // Lấy danh sách tất cả users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Lấy user theo ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Tạo user mới - CẢI THIỆN để phù hợp với đăng ký
    public User createNewUser(User user) {
        // Đảm bảo username không null (sẽ được set trong @PrePersist nếu null)
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            user.setUsername(user.getEmail());
        }
        return userRepository.save(user);
    }

    // Cập nhật user theo id - CẢI THIỆN để tránh ghi đè những field không cần thiết
    public User updateUserById(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    // CHỈ cập nhật những field được phép thay đổi
                    if (updatedUser.getUsername() != null && !updatedUser.getUsername().trim().isEmpty()) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if (updatedUser.getEmail() != null && !updatedUser.getEmail().trim().isEmpty()) {
                        user.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getFullName() != null) {
                        user.setFullName(updatedUser.getFullName());
                    }
                    if (updatedUser.getProfilePictureUrl() != null) {
                        user.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
                    }
                    if (updatedUser.getCurrentMembershipPackageId() != null) {
                        user.setCurrentMembershipPackageId(updatedUser.getCurrentMembershipPackageId());
                    }
                    if (updatedUser.getSubscriptionEndDate() != null) {
                        user.setSubscriptionEndDate(updatedUser.getSubscriptionEndDate());
                    }
                    if (updatedUser.getCoachId() != null) {
                        user.setCoachId(updatedUser.getCoachId());
                    }
                    if (updatedUser.getRole() != null && !updatedUser.getRole().trim().isEmpty()) {
                        user.setRole(updatedUser.getRole());
                    }
                    // KHÔNG cập nhật password, registrationDate, lastLoginDate ở đây
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    // Xóa user theo id
    public boolean deleteUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                })
                .orElse(false);
    }

    // Tìm user theo username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Tìm user theo email - QUAN TRỌNG cho đăng nhập
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Lấy danh sách users theo role
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Kiểm tra username đã tồn tại chưa - QUAN TRỌNG cho đăng ký
    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Kiểm tra email đã tồn tại chưa - QUAN TRỌNG cho đăng ký
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Cập nhật last login date - QUAN TRỌNG cho đăng nhập
    public void updateLastLoginDate(Integer userId) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.setLastLoginDate(LocalDateTime.now());
                    userRepository.save(user);
                });
    }

    // THÊM MỚI: Cập nhật mật khẩu (cho chức năng đổi mật khẩu sau này)
    public boolean updatePassword(Integer userId, String newPasswordHash) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setPasswordHash(newPasswordHash);
                    userRepository.save(user);
                    return true;
                })
                .orElse(false);
    }

    // THÊM MỚI: Validate email format (có thể dùng cho validation)
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    // Lấy danh sách users có coach
    public List<User> getUsersWithCoach() {
        return userRepository.findByCoachIdIsNotNull();
    }

    // Lấy danh sách users theo coach ID
    public List<User> getUsersByCoachId(Integer coachId) {
        return userRepository.findByCoachId(coachId);
    }
}