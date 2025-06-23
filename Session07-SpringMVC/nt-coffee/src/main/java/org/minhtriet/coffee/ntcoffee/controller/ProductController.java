package org.minhtriet.coffee.ntcoffee.controller;

import jakarta.servlet.http.HttpSession;
import org.minhtriet.coffee.ntcoffee.entity.Account;
import org.minhtriet.coffee.ntcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("p", new Product());
        return "product-form";
    }


    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        //có trong tay id số mấy rồi thì vào database query lên, ta tạm thời hardcode
        Product product;
        if(id.equalsIgnoreCase("1")){
            product = new  Product("1", "Coffee Indonesia", 20000);
        } else if (id.equalsIgnoreCase("2")) {
            product =  new Product("2", "Cà phê Ả Rập", 15000);
        }else {
            product = new Product("3", "Coffee Latte", 18000);
        }
        model.addAttribute("p", product);
        return "product-form";
    }

    @GetMapping("/HoangXuanTrinh")
    public String list(Model model, HttpSession session) {
        List<Product> productList = List.of(new Product("1", "Coffee Indonesia", 20000),
                new Product("2", "Cà phê Ả Rập", 15000),
                new Product("3", "Coffee Latte", 18000)

        );
       // model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
       // model.addAttribute("sentUser", session.getAttribute("sentUser"));
        //có session lo giữ acc rồi
        Account acc = (Account) session.getAttribute("acc");
        model.addAttribute("role", acc.getRole());


        //gửi danh sách sản phẩm + role sang trang!!!
        // Có role thì bật tắt nút bấm
        return "products";
    }
}
