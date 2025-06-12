package com.minhtriet.spring.ioc.v4beanduplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV4 {

    public static void main(String[] args) {
     ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

     HelloMessage sms = context.getBean("email" ,HelloMessage.class);
     sms.sayHello("VÕ VĂN TÁM");
    }
}
