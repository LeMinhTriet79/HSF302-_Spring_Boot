package org.minhtriet.coffee.ntcoffee.controller;

import jakarta.servlet.http.HttpSession;
import org.minhtriet.coffee.ntcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/HoangXuanTrinh")
    public String list(Model model, HttpSession session) {
        List<Product> productList = List.of(new Product("1", "Coffee Indonesia", 20000),
                new Product("2", "Cà phê Ả Rập", 15000),
                new Product("3", "Coffee Latte", 18000)

        );
       // model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
        model.addAttribute("sentUser", session.getAttribute("sentUser"));
        return "products";
    }
}
