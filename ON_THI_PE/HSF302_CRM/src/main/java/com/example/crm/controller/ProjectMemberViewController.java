package com.example.crm.controller;

import com.example.crm.entity.ProjectMember;
import com.example.crm.service.ProjectService;
import com.example.crm.service.UserService;
import com.example.crm.service.ProjectMemberService; // Bạn cần tự tạo service này
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projectmembers")
public class ProjectMemberViewController {
    @Autowired
    private ProjectMemberService projectMemberService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    // Danh sách thành viên dự án
    @GetMapping
    public String listProjectMembers(Model model) {
        model.addAttribute("projectMembers", projectMemberService.getAllProjectMembers());
        return "projectmember/list";
    }

    // Form thêm thành viên dự án
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("projectMember", new ProjectMember());
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("users", userService.getAllUsers());
        return "projectmember/form";
    }

    // Lưu thành viên dự án
    @PostMapping("/save")
    public String saveProjectMember(@ModelAttribute("projectMember") ProjectMember projectMember) {
        projectMemberService.createProjectMember(projectMember);
        return "redirect:/projectmembers";
    }

    // Xóa thành viên dự án
    @GetMapping("/delete/{id}")
    public String deleteProjectMember(@PathVariable Long id) {
        projectMemberService.deleteProjectMember(id);
        return "redirect:/projectmembers";
    }
}
