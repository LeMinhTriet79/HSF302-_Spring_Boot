package com.minhtriet.spring.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.minhtriet.spring.di")
public class AppConfig {
    //Khỏi chủ động tạo bằng tay!!! @Bean
}
