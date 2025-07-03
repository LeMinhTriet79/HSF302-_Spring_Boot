package com.giaolang.coffee.repository;

import com.giaolang.coffee.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, String> {
    Account findByUsernameAndPassword(String username, String password);
}
