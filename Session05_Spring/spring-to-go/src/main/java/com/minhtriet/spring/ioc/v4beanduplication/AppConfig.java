package com.minhtriet.spring.ioc.v4beanduplication;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//không thèm Scan do chủ động tạo bean

public class AppConfig {
    @Bean("sms")
  //  @Primary
    public HelloMessage smsMessage() {
        return new HelloMessage("SMS");
    }

    @Bean("email") //đặt tên cho bean để phân biệt
    public HelloMessage emailMessage() {
        return new HelloMessage("EMAIL");
    }
}
