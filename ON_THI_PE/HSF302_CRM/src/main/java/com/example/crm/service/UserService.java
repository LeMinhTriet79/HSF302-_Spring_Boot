package com.example.crm.service;

import com.example.crm.entity.Role;
import com.example.crm.entity.User;
import com.example.crm.repository.RoleRepository;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service quản lý người dùng (User)
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // Lấy tất cả user (Admin xem tất cả, Leader có thể xem nhân viên)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Lấy user theo id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    // Tạo mới user (Admin)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Sửa thông tin user (Admin, user tự cập nhật tài khoản)
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        return userRepository.save(user);
    }

    // Xoá user (Admin)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Cấp quyền cho user (Admin)
    public User assignRole(Long userId, String roleName) {
        User user = userRepository.findById(userId).orElseThrow();
        Role role = roleRepository.findByName(roleName).orElseThrow();
        user.setRole(role);
        return userRepository.save(user);
    }

    // Tìm user theo email (dùng nội bộ)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}

