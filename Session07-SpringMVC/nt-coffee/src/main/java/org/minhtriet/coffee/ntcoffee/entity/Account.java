package org.minhtriet.coffee.ntcoffee.entity;

// tuơng lai là @Entity
public class Account {
    private String username;
    private String password;
    private int role; //1 là admin, 2 là staff

    public Account(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Account() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
