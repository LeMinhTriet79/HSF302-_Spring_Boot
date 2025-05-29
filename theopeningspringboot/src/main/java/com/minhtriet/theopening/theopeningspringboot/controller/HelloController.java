package com.minhtriet.theopening.theopeningspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/buoi1/hello")
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        int a = 2;
        int b = 2;
        int c = a + b;
        return String.valueOf(c) + " Hello THE OPENING SPRING BOOT !!!";
    }

}
