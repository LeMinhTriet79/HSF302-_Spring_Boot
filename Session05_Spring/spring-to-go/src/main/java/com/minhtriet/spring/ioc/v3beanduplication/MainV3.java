package com.minhtriet.spring.ioc.v3beanduplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {

    public static void main(String[] args) {
     ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

     HelloMessage sms = context.getBean(HelloMessage.class);
     sms.sayHello("Hello Spring World!");
    }
}
