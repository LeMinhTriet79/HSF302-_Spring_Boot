package com.example.crm.controller;

import com.example.crm.entity.Task;
import com.example.crm.service.TaskService;
import com.example.crm.service.ProjectService;
import com.example.crm.service.UserService;
import com.example.crm.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskViewController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskStatusService taskStatusService;

    // Danh sách task (chỉ lấy task cá nhân nếu là MEMBER)
    @GetMapping
    public String listTasks(Model model, Authentication authentication) {
        String email = authentication.getName(); // Lấy email user đăng nhập
        boolean isMember = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("MEMBER"));
        List<Task> tasks;
        if (isMember) {
            // Member chỉ xem các task được giao cho mình
            tasks = taskService.getTasksByAssigneeEmail(email);
        } else {
            // Admin, Leader xem toàn bộ task
            tasks = taskService.getAllTasks();
        }
        model.addAttribute("tasks", tasks);
        return "task/list";
    }

    // Form thêm task
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("statuses", taskStatusService.getAllStatus());
        return "task/form";
    }

    // Lưu task mới/sửa task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.createTask(task, task.getProject().getId(), task.getAssignee().getId(), task.getStatus().getId());
        return "redirect:/tasks";
    }

    // Form sửa task
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("statuses", taskStatusService.getAllStatus());
        return "task/form";
    }

    // Xóa task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
