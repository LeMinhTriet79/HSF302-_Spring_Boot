package com.example.crm.service;

import com.example.crm.entity.Role;
import com.example.crm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service quản lý quyền (role)
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Lấy tất cả quyền (dùng cho Admin)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Tạo mới một quyền (dùng cho Admin)
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Sửa thông tin quyền (dùng cho Admin)
    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setName(roleDetails.getName());
        role.setDescription(roleDetails.getDescription());
        return roleRepository.save(role);
    }

    // Xoá quyền (dùng cho Admin)
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    // Tìm quyền theo tên (dùng nội bộ)
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }
}
