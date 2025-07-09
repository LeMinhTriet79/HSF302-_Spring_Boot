package com.example.crm.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "task_status")
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // "Chưa bắt đầu", "Đang thực hiện", "Đã hoàn thành"

    private String description;

    @OneToMany(mappedBy = "status")
    private List<Task> tasks;

    // Getters and Setters
    // ...
    public TaskStatus() {}

    public TaskStatus( String name, String description, List<Task> tasks) {

        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
