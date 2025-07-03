package com.huynqb.coffee.controller;

import com.huynqb.coffee.entity.Product;
import com.huynqb.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Hiển thị danh sách sản phẩm
    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "products"; //.html
    }

    // Vào form chỉnh sửa
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("selectedOne", product);
        return "products-form"; //.html
    }

    // Vào form tạo mới
    @GetMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("selectedOne", new Product());
        return "products-form"; //.html
    }
}
