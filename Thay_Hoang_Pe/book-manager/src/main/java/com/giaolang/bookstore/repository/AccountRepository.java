package com.giaolang.bookstore.repository;

import com.giaolang.bookstore.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByEmail(String email);
}
