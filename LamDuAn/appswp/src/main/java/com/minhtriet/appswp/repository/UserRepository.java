package com.minhtriet.appswp.repository;

import com.minhtriet.appswp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Tìm user theo username - QUAN TRỌNG cho đăng nhập
    User findByUsername(String username);

    // Tìm user theo email - QUAN TRỌNG cho đăng nhập/đăng ký
    User findByEmail(String email);

    // Lấy users theo role - để phân quyền
    List<User> findByRole(String role);

    // Kiểm tra username đã tồn tại - QUAN TRỌNG cho đăng ký
    boolean existsByUsername(String username);

    // Kiểm tra email đã tồn tại - QUAN TRỌNG cho đăng ký
    boolean existsByEmail(String email);

    // Lấy users có coach (coachId không null)
    List<User> findByCoachIdIsNotNull();

    // Lấy users theo coach ID cụ thể
    List<User> findByCoachId(Integer coachId);

    // THÊM MỚI: Tìm theo username và email (cho đăng nhập linh hoạt)
    User findByUsernameOrEmail(String username, String email);

    // THÊM MỚI: Lấy users đang active (có thể thêm field isActive sau)
    // List<User> findByIsActiveTrue();
}