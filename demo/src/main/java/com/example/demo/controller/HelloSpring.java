package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpring {
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot, Nostagial";
    }

    @GetMapping("/hello")
    public int math() {
        int a = 5;
        int b = 2;

        return a + b;
    }
}
