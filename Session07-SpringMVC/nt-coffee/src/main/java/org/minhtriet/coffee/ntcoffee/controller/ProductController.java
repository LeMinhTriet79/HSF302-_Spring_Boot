package org.minhtriet.coffee.ntcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/HoangXuanTrinh")
    public String list(Model model) {
        return "products";
    }
}
