package com.example.seminar.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Entity
@Getter
@Setter
public class Student {
    @Id
            @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    long id;


    @NotBlank(message = "Full Name can not blank")
    String fullName;
    @NotBlank(message = "Student code can not blank")
            @Pattern(regexp = "SE\\d{6}", message = "Student code must be 5-10 characters")
            @Column(unique = true)
    String studentCode;

}
