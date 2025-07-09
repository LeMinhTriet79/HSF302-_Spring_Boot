package com.example.crm.service;

import com.example.crm.entity.*;
import com.example.crm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Quản lý công việc (Task)
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    // Lấy tất cả công việc (Admin hoặc Leader)
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Lấy công việc theo id
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    // Lấy công việc theo dự án
    public List<Task> getTasksByProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        return taskRepository.findByProject(project);
    }

    // Lấy công việc được giao cho user (Member xem task của mình)
    public List<Task> getTasksByAssignee(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return taskRepository.findByAssignee(user);
    }

    // Tạo mới công việc (Leader)
    public Task createTask(Task task, Long projectId, Long assigneeId, Long statusId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        User assignee = userRepository.findById(assigneeId).orElseThrow();
        TaskStatus status = taskStatusRepository.findById(statusId).orElseThrow();
        task.setProject(project);
        task.setAssignee(assignee);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    // Sửa thông tin công việc (Leader)
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setName(taskDetails.getName());
        task.setDescription(taskDetails.getDescription());
        task.setStartDate(taskDetails.getStartDate());
        task.setEndDate(taskDetails.getEndDate());
        // Không sửa project, assignee, status ở đây
        return taskRepository.save(task);
    }

    // Xoá công việc (Leader)
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Member cập nhật trạng thái công việc (progress)
    public Task updateTaskStatus(Long taskId, Long statusId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        TaskStatus status = taskStatusRepository.findById(statusId).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByAssigneeEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return taskRepository.findByAssignee(user);
    }
}
