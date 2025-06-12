package com.minhtriet.superapp.di.v1constructor;



public class MainDIV1 {
public static void main(String[] args) {

   // MailSender mailSender = new MailSender();
//    UserService userService = new UserService(mailSender);//tiêm obj vào trong

    UserService userService = new UserService(new MailSender());//tiêm obj vào trong

    //Main class là nơi tạo ra object dependency và truyền vào nơi cần
    //new MailSender
    //Main còn gọi là container, nơi chứa object dependency
    //hành động class không chủ động new, ko chủ độngvieecjc kiểm soát tạo dependency nữa mà đưa cho nơi khác lo. ở đây là Main
    //Ta class A, class UserService đã trao quyền kiểm soát việc new dependency cho chỗ khác - đc gọi là : IoC Inversion of Control, đảo ngược điều khiển code
    //thay vì mình (Service) lo hết việc tạo depedency, nay để cho đứa khác lo

    //Spring, spring boot lo cho mình 2 việc: tạo nên object dependency, chích/tiêm vào luôn, ioc Container(ApplicationContext)

    userService.registerAccount("<hoangngoctrinh@gmail.com>");
}
}
