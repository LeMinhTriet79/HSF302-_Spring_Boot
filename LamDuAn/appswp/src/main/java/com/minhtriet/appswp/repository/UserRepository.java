package com.minhtriet.appswp.repository;

import com.minhtriet.appswp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
