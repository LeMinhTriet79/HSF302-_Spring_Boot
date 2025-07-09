package com.giaolang.tobaccoshop.controller;

import com.giaolang.tobaccoshop.entity.Product;
import com.giaolang.tobaccoshop.entity.Category;
import com.giaolang.tobaccoshop.service.ProductService;
import com.giaolang.tobaccoshop.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String listProducts(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model,
            HttpSession session
    ) {
        List<Product> products;
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.searchByName(keyword);
        } else {
            products = productService.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        model.addAttribute("user", session.getAttribute("user")); // <-- dòng này!
        return "products";
    }


    @GetMapping("/product/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product-form";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) return "redirect:/products";
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "product-form";
    }

    @PostMapping("/product/save")
    public String saveProduct(
            @ModelAttribute("product") Product product,
            @RequestParam("category") Long categoryId
    ) {
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
