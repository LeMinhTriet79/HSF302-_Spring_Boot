package hsf302.sp25.se171588.service;

import hsf302.sp25.se171588.entity.SonyAccounts;
import hsf302.sp25.se171588.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;

    public SonyAccounts getUserByRole(int role){
        SonyAccounts user = accountsRepository.getUserByRole(role);
        return user;
    }

    public SonyAccounts create(SonyAccounts user){
        return accountsRepository.save(user);
    }
    public SonyAccounts verify(String email, String phone) throws Exception {
        SonyAccounts sonyAccounts=accountsRepository.getUserByEmailContainingAndPhoneContaining(email, phone);
        if(!sonyAccounts.getEmail().equals(email)){
            throw new Exception("Invalid email");
        }
        if (!sonyAccounts.getPhone().equals(phone)){
            throw new Exception("Invalid password");
        }
        return sonyAccounts;
    }
    public SonyAccounts findByEmail(String email) {
        SonyAccounts sonyAccounts= accountsRepository.getUserByEmail(email);
        return sonyAccounts;
    }
}
