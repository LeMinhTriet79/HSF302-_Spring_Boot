package com.example.thi_thu.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    private String directorName;

    public Director() {}

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    // Getters & Setters
}
