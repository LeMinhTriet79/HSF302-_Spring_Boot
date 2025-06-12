package com.minhtriet.spring.ioc.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration// đây là nơi khởi nguồn tạo ra các bean - các object đc new
//object của class nào được new thì cần chỉ ra qua lệnh @Component
//@ComponentScan("com.minhtriet.spring.ioc.v2bean")
public class AppConfig {
    @Bean // object được new ở hàm này sẽ đi vào Container
    //và Object này sẽ mang cái tên là helloMessage
    // tên hàm phá quy tắc Verb + object mà tên hàm khai báo như biến
    public  HelloMessage vanTamVo() {
        return new HelloMessage();
    } //  chủ động new object bằng tay như truyền thống
    //nhưng sau đó đẩy object này cho container quản lý


}

// Có những cách để tạo và dùng một đối tượng obj
//C1 : Chủ động new, tự new - version no -ioc từ đầu giờ
//c2: new tự động qua @ComponetScan - v1
//Annotation Configuaration
//C3: chủ động new, tự new, nhưng thẩy cho Container quản lý
// Java -  Based Configuration

//C4: new tự động luôn, nhưng phải cấu hình, khai báo bean, class cần to object qua file .xml - legacy - cách cũ
