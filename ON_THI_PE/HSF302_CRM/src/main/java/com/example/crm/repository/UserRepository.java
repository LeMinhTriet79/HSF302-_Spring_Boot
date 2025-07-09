package com.example.crm.repository;

import com.example.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Repository quản lý bảng User (người dùng)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
