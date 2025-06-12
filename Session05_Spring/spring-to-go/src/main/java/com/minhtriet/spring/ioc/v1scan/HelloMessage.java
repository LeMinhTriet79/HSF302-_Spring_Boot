package com.minhtriet.spring.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component// hoặc @Service, @Repository
public class HelloMessage {
    public void sayHello(String msg) {
        System.out.println("The message below comes HelloMessage object\n" + msg);
    }
}
