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
    // NHỜ SERVICE GIÚP LẤY FULL DATA TỪ TABLE
    // TỰ SERVICE CHƠI VỚI REPO. NGUYÊN LÝ SRP (Single Responsibility Principle)
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        // Trả về tên view để hiển thị danh sách sản phẩm
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("prods", productList); // Đưa danh sách sản phẩm vào model, thùng hàm đi kèm cha chứa full sản phẩm từ table
        return "products"; // Tên view sẽ là products.html trong thư mục templates
    }


}
