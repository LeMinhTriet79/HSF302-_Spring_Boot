package com.minhtriet.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDI {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        //hãu new giúp tôi Service
        //khoong cần new UserRepo, EmailSender
        //không cần gọi constructor của Service
        userService.registerAccount();
    }
}
