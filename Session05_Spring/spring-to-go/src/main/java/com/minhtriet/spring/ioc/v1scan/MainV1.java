package com.minhtriet.spring.ioc.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV1 {
    public static void main(String[] args) {
        //Hàm main chạy, báo cho máy ảo Java, lôi thư viện Spring/ thư viện con của nó vào cuộc quản lí các object, tạo ra một object chung/trùm tên là ApplicationContext
        //giống kiểu chơi DB qua JPA thì có trùm cuối EntityManagerFactory

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Phía sau hậu trường thì context là một vùng RAM(OBJ) gọi là Ioc container
        //Chứa các object đc new sẵn (thằng nào có @Component, @Service, @Repo
        //Tìm những @ cần new có khai báo trong AppConfig class

        HelloMessage helloMessage = context.getBean(HelloMessage.class);
        //giờ nó đã new, giờ sài thôi
        //bean là một object được new tự động bởi Spring Context/Container
        //ta chỉ get ra để dùng, lấy từ chỗ chứa - container
        helloMessage.sayHello("Hello Spring World!");


    }
}
