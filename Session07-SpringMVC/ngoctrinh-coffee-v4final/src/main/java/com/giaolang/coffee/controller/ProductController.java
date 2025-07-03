package com.giaolang.coffee.controller;

import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.service.ProductService;
import com.giaolang.coffee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách sản phẩm, có search và truyền role từ session
    @GetMapping
    public String listProducts(Model model,
                               @RequestParam(required = false) String keyword,
                               HttpSession session) {
        List<Product> products = productService.getAllProducts();
        if (keyword != null && !keyword.isEmpty()) {
            List<Product> filtered = new ArrayList<>();
            for (Product p : products) {
                if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    filtered.add(p);
                }
            }
            products = filtered;
        }
        model.addAttribute("products", products);

        // Lấy role từ session để Thymeleaf kiểm tra phân quyền
        Object role = session.getAttribute("role");
        model.addAttribute("role", role);

        return "products";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());

        // Truyền role để kiểm tra quyền ở view nếu cần
        Object role = session.getAttribute("role");
        model.addAttribute("role", role);

        return "product-form";
    }

    // Lưu sản phẩm mới/đã sửa
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // Gán lại đối tượng Category từ DB dựa trên id lấy từ form
        if (product.getCate() != null && product.getCate().getId() != null) {
            List<Category> categories = categoryService.getAllCategories();
            for (Category c : categories) {
                if (c.getId().equals(product.getCate().getId())) {
                    product.setCate(c);
                    break;
                }
            }
        } else {
            product.setCate(null);
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model, HttpSession session) {
        List<Product> products = productService.getAllProducts();
        Product product = null;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                product = p;
                break;
            }
        }
        if (product == null) return "redirect:/products";
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());

        // Truyền role để kiểm tra quyền ở view nếu cần
        Object role = session.getAttribute("role");
        model.addAttribute("role", role);

        return "product-form";
    }

    // Xoá sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        List<Product> products = productService.getAllProducts();
        Product product = null;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                product = p;
                break;
            }
        }
        if (product != null) {
            productService.deleteProduct(product);
        }
        return "redirect:/products";
    }
}
