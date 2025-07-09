package com.example.crm.repository;

import com.example.crm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Repository quản lý bảng Role (quyền)
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
