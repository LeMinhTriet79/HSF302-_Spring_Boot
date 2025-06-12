package com.minhtriet.spring.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Class này mới là cái chạy đầu tiên

@Configuration //đây là class quan trọng
@ComponentScan("com.minhtriet.spring.ioc.v1scan")
//ra lệnh cho thư viện Spring quét qua toàn bộ các class trong thư mục/pakega ở trên, xem có object nào cần phải tạo ra hay không?? thì tạo/new luôn giùm để lát lôi ra mà sài á con

//Để phn biệt được object nào cần tạo object nào ko thì đánh dấu class đó bằng mộ ttrong ba từ khóa : @Component, @Service, @Repository
//@Component bao luôn @Service, @Repository
public class AppConfig {


}
