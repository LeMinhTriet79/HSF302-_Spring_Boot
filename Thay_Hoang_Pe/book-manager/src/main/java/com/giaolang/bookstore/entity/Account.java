package com.giaolang.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id; // Khóa chính

    @Column(name = "Email", length = 100, nullable = false, unique = true)
    private String email; // Email đăng nhập

    @Column(name = "Password", length = 30, nullable = false, columnDefinition = "NVARCHAR(30)")
    private String password; // Mật khẩu

    //@Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private int role; // Vai trò: ADMIN 1, STAFF 2, MEMBER 3

    // Constructor không tham số
    public Account() {
    }

    // Constructor có tham số, ko truyền id do tự tăng
    public Account(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter và Setter
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

