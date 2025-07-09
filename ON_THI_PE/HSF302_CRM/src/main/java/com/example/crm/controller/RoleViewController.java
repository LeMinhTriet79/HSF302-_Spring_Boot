package com.example.crm.controller;

import com.example.crm.entity.Role;
import com.example.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleViewController {
    @Autowired
    private RoleService roleService;

    // Danh sách quyền
    @GetMapping
    public String listRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "role/list";
    }

    // Form thêm quyền
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("role", new Role());
        return "role/form";
    }

    // Lưu quyền mới/sửa quyền
    @PostMapping("/save")
    public String saveRole(@ModelAttribute("role") Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }

    // Form sửa quyền
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("role", roleService.getAllRoles()
                .stream().filter(r -> r.getId().equals(id)).findFirst().orElse(new Role()));
        return "role/form";
    }

    // Xóa quyền
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}
