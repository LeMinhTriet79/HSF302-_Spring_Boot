package com.example.crm.repository;

import com.example.crm.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Repository quản lý bảng TaskStatus (trạng thái công việc)
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Optional<TaskStatus> findByName(String name);
}
