package com.example.crm.service;

import com.example.crm.entity.TaskStatus;
import com.example.crm.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Quản lý danh mục trạng thái công việc
public class TaskStatusService {
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    // Lấy tất cả trạng thái
    public List<TaskStatus> getAllStatus() {
        return taskStatusRepository.findAll();
    }

    // Tạo mới trạng thái (Admin)
    public TaskStatus createStatus(TaskStatus status) {
        return taskStatusRepository.save(status);
    }

    // Sửa trạng thái (Admin)
    public TaskStatus updateStatus(Long id, TaskStatus statusDetails) {
        TaskStatus status = taskStatusRepository.findById(id).orElseThrow();
        status.setName(statusDetails.getName());
        status.setDescription(statusDetails.getDescription());
        return taskStatusRepository.save(status);
    }

    // Xoá trạng thái (Admin)
    public void deleteStatus(Long id) {
        taskStatusRepository.deleteById(id);
    }
}
