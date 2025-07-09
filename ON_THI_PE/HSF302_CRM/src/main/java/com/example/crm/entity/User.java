package com.example.crm.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;
    private String address;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Optional: for project leader mapping
    @OneToMany(mappedBy = "leader")
    private List<Project> projectsLed;

    // Optional: tasks assigned to user
    @OneToMany(mappedBy = "assignee")
    private List<Task> tasksAssigned;

    // Optional: project membership mapping
    @OneToMany(mappedBy = "user")
    private List<ProjectMember> projectMembers;

    // Getters and Setters
    // ...

    public User() {}

    public User( String email, String password, String name, String address, String phone, Role role, List<Project> projectsLed, List<Task> tasksAssigned, List<ProjectMember> projectMembers) {

        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.projectsLed = projectsLed;
        this.tasksAssigned = tasksAssigned;
        this.projectMembers = projectMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Project> getProjectsLed() {
        return projectsLed;
    }

    public void setProjectsLed(List<Project> projectsLed) {
        this.projectsLed = projectsLed;
    }

    public List<Task> getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(List<Task> tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public List<ProjectMember> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<ProjectMember> projectMembers) {
        this.projectMembers = projectMembers;
    }
}
