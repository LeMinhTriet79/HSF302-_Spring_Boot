package com.giaolang.bookmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserAccount")
public class UserAccount {

    @Id
    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private int role;   //quy ước, xem đề thi 1: Admin, 2: Staff, 3: Member để set quyền
    //để mai mốt if đúng con số 1 2 3 phân quyen

    //contructor rỗng, full tham số (loại trừ cột tự tăng nếu có)
    //getter/setter

    public UserAccount() {
    }

    public UserAccount(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
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
}
