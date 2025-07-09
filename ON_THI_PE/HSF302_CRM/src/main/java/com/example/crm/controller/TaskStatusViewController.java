package com.example.crm.controller;

import com.example.crm.entity.TaskStatus;
import com.example.crm.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/taskstatus")
public class TaskStatusViewController {
    @Autowired
    private TaskStatusService taskStatusService;

    // Danh sách trạng thái
    @GetMapping
    public String listStatuses(Model model) {
        model.addAttribute("statuses", taskStatusService.getAllStatus());
        return "taskstatus/list";
    }

    // Form thêm trạng thái
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("status", new TaskStatus());
        return "taskstatus/form";
    }

    // Lưu trạng thái mới/sửa trạng thái
    @PostMapping("/save")
    public String saveStatus(@ModelAttribute("status") TaskStatus status) {
        taskStatusService.createStatus(status);
        return "redirect:/taskstatus";
    }

    // Form sửa trạng thái
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("status", taskStatusService.getAllStatus()
                .stream().filter(s -> s.getId().equals(id)).findFirst().orElse(new TaskStatus()));
        return "taskstatus/form";
    }

    // Xóa trạng thái
    @GetMapping("/delete/{id}")
    public String deleteStatus(@PathVariable Long id) {
        taskStatusService.deleteStatus(id);
        return "redirect:/taskstatus";
    }
}
