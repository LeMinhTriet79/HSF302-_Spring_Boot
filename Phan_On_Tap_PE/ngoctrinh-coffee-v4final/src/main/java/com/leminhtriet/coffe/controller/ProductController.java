package com.leminhtriet.coffe.controller;

import com.leminhtriet.coffe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller//chịu trách nhiệm hứng các url từ trình duyệt (get post...)
//hứng data gửi lên cho server
//gọi hàm sử lý
//3. return lại trang web
public class ProductController {

    //tiêm productservice, hoặc tiêm qua contruct, fiel,...
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public String showAllProducts(Model model) {//Model là thùng chứa infor sẽ gửi cho trang trước khi render
        //kèm cái thùng chứa data, nhờ thymleaf trộn, mix, merge, reder, đưa cho tomcat bản hoàn chỉnh thuần html

        model.addAttribute("products", productService.getAllProducts()); //gửi danh sách đọc từ table cho vào thùng

        return "products";
    }

    @GetMapping("/products/edit/{id}")
    public String showAllProducts(@PathVariable("id") String id, Model model) {//Model là thùng chứa infor sẽ gửi cho trang trước khi render
        //kèm cái thùng chứa data, nhờ thymleaf trộn, mix, merge, reder, đưa cho tomcat bản hoàn chỉnh thuần html

        model.addAttribute("selectedOne", productService.getProductById(id)); //gửi danh sách đọc từ table cho vào thùng

        return "product-form";
    }

    ///products/new
    @GetMapping("/products/new/")
    public String create(@PathVariable("id") String id, Model model) {//Model là thùng chứa infor sẽ gửi cho trang trước khi render
        //kèm cái thùng chứa data, nhờ thymleaf trộn, mix, merge, reder, đưa cho tomcat bản hoàn chỉnh thuần html

        model.addAttribute("selectedOne", productService.getProductById(id)); //gửi danh sách đọc từ table cho vào thùng

        return "product-form";
    }
}
