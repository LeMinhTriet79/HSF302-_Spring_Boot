// AccountRepo.java
package com.giaolang.tobaccoshop.repository;
import com.giaolang.tobaccoshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}