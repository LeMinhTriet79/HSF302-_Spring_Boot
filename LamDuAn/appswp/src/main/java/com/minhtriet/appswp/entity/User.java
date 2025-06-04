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
    private long userId;

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
    private Long coachId;

    @Column(name = "Role", nullable = false, length = 255)
    private String role = "member"; // Default value

    @PrePersist
    protected void onCreate() {
        // Tự động set thời gian đăng ký khi tạo user mới
        if (registrationDate == null) {
            registrationDate = LocalDateTime.now();
        }
        // Đảm bảo role luôn có giá trị mặc định
        if (role == null || role.trim().isEmpty()) {
            role = "member";
        }
        // THÊM MỚI: Nếu username null, dùng email làm username
        if (username == null || username.trim().isEmpty()) {
            username = email;
        }
    }
}