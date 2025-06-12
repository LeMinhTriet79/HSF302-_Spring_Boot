package com.minhtriet.spring.ioc.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainV2 {
    public static void main(String[] args) {
        // Gọi trùm lên để quán lý object
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       HelloMessage helloMessage = (HelloMessage) context.getBean("vanTamVo"); // @Bean bên kia, lấy cáo tên
       helloMessage.sayHello("Hello Spring World From Manual Create Bean");

        HelloMessage hello2 =  context.getBean(HelloMessage.class); // @Bean bên kia, lấy cáo tên
        hello2.sayHello("Hello Spring World From Manual Create Bean (No Casting - không ép kiểu)");

    }
}
