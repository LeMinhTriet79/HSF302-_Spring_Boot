// AccountService.java
package com.giaolang.tobaccoshop.service;
import com.giaolang.tobaccoshop.entity.Account;
import com.giaolang.tobaccoshop.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    public Account login(String username, String password) {
        Account acc = accountRepo.findByUsername(username);
        if(acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }
}
