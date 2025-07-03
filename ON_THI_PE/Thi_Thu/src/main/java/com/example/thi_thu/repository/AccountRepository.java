package com.example.thi_thu.repository;

import com.example.thi_thu.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmailAndPassword(String email,String password);
}
