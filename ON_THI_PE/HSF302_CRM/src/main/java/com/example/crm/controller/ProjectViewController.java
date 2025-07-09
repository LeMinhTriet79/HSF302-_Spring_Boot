package com.example.crm.controller;

import com.example.crm.entity.Project;
import com.example.crm.entity.User;
import com.example.crm.service.ProjectService;
import com.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectViewController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    // Danh sách dự án
    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "project/list";
    }

    // Form thêm dự án
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("leaders", userService.getAllUsers()); // Bạn lọc leader bên view hoặc service đều được
        return "project/form";
    }

    // Lưu dự án mới/sửa dự án
    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project project) {
        // Nếu cần gán leaderId riêng thì xử lý lại ở đây
        projectService.createProject(project, project.getLeader().getId());
        return "redirect:/projects";
    }

    // Form sửa dự án
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        model.addAttribute("leaders", userService.getAllUsers());
        return "project/form";
    }

    // Xóa dự án
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }
}
