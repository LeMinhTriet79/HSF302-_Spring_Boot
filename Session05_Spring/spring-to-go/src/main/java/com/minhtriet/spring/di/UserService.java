package com.minhtriet.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Service cần sự trợ giúp từ Repo, EmailSender, 2 đưa này là Dependency
    //code cũ, ko DI, chủ động new
    private UserRepo repo ; //= new UserRepo();
    private EmailSender emailSender; // = new EmailSender();

    //Code moới, ko new, chờ tiêm chích vào, Ai new??? --> Spring new giúp, chích giùm luôn

    //Chích/tiêm có 3 cách:
    //chích/tiêm qua Constructor, ai new 2 thằng đưa vào
   // @Autowired //new ở đâu vào chích vào giúp
    public UserService(UserRepo repo, EmailSender emailSender){
        this.repo = repo;
        this.emailSender = emailSender;
    }
    public void registerAccount(){
        repo.getAll();// in câu danh sách Account
        //để kểm tra có trùng Email hay ko
        //repo.persit().save(user);
        emailSender.sendEmail();
    }
}
