package com.example.thi_thu.service;

import com.example.thi_thu.entity.Account;
import com.example.thi_thu.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    public Account login(String email, String password) {
        return accountRepo.findByEmailAndPassword(email, password);
    }
}
