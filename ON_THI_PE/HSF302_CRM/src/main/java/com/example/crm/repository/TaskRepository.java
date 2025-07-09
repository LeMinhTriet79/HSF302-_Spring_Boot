package com.example.crm.repository;

import com.example.crm.entity.Project;
import com.example.crm.entity.Task;
import com.example.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repository quản lý bảng Task (công việc)
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Lấy tất cả task của một project
    List<Task> findByProject(Project project);

    // Lấy tất cả task được giao cho một user
    List<Task> findByAssignee(User assignee);

    List<Task> findByAssigneeEmail(String email);

}
