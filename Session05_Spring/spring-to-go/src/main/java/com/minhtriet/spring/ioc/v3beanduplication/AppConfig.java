package com.minhtriet.spring.ioc.v3beanduplication;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//không thèm Scan do chủ động tạo bean

public class AppConfig {
    @Bean
    @Primary
    public HelloMessage smsMessage() {
        return new HelloMessage("SMS");
    }

    @Bean
    public HelloMessage emailMessage() {
        return new HelloMessage("EMAIL");
    }
}
