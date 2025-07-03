package com.huynqb.coffee.controller;

import com.huynqb.coffee.entity.Product;
import com.huynqb.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {


    //Nhờ service giúp lấy full data
    //tự service chơi với repo. nguyen lý SRP
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        //thùng hàng đi kèm trang chứa full sản phẩm từ table
        return "products"; //.html
    }

}
