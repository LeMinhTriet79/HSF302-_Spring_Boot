package com.minhtriet.appswp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Username", nullable = false, unique = true, length = 255)
    private String username;

    @Column(name = "PasswordHash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "FullName", length = 255)
    private String fullName;

    @Column(name = "RegistrationDate", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "LastLoginDate")
    private LocalDateTime lastLoginDate;

    @Column(name = "ProfilePictureURL", length = 255)
    private String profilePictureUrl;

    @Column(name = "CurrentMembershipPackageID")
    private Integer currentMembershipPackageId;

    @Column(name = "SubscriptionEndDate")
    private LocalDate subscriptionEndDate;

    @Column(name = "CoachID")
    private Integer coachId;

    @Column(name = "Role", nullable = false, length = 255)
    private String role = "member"; // Default value

    @PrePersist
    protected void onCreate() {
        if (registrationDate == null) {
            registrationDate = LocalDateTime.now();
        }
        if (role == null) {
            role = "member";
        }
    }
}