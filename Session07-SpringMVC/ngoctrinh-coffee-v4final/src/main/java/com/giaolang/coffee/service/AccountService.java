package com.giaolang.coffee.service;

import com.giaolang.coffee.entity.Account;
import com.giaolang.coffee.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account checkLogin(String username, String password) {
        return accountRepo.findByUsernameAndPassword(username, password);
    }

    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

}
