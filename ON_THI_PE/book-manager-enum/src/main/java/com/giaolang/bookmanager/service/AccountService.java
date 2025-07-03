package com.giaolang.bookmanager.service;

import com.giaolang.bookmanager.entity.UserAccount;
import com.giaolang.bookmanager.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    //ta cx chỉ cần hàm select * from Account where email = email cần logn; ko cần lấy all users, vì login chỉ cần lấy 1 Account coi có tồn tại hay ko
    //cx cần thêm, xoá, sửa Account
    //chích cái Account Repo
    @Autowired
    private AccountRepo repo; //ko new vì đc chích vào

    //đưa email vào hàm này, hàm này gọi repo đi tìm 1 Account where theo email
    //email đang là key của table Account
    //
    public UserAccount findByEmail(String email) {
        return repo.findById(email).orElse(null);
        //JDK sau này: Option<UserAccount> x  gói lại x là null hoặc là object cụ thể. x.orElse(null)  lấy ra x, hoặc là bằng, tránh viết if else
        //          ~         UserAccount x
        //
    }

}
