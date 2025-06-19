package org.minhtriet.coffee.ntcoffee.controller;

import org.minhtriet.coffee.ntcoffee.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller//bean tồn tại trong ram, tomcat, để handle, cái request url guiwrl lên
//@RequestMapping("/login")
public class LoginController {
    //các hàm phục vụ nhu cầu Login và Map tới cái xẹt / , /login, post của login

    //load/trả trang login cho Thymeleaf -> render -> Tomcat -> browser
    @GetMapping( {"/", "/login"})
    public String showLogin() {
        return "login"; // ghép cái tên trang + .html -> login.html đưa cho Thymeleaf; gửi kèm thêm data
        //nếu cần - Model model
    }

    @PostMapping("/doLogin")
    public String doLoginAhihi(@RequestParam("user") String username, @RequestParam("pass") String password, Model model) {

        //chuẩn bị sẵn danh sách món cafe, list<>, đính kèm theo thằng thùng chưa model
        //Thùng chứa model sẽ chưa email + list
        //


        List<Product> productList = List.of(new Product("1", "Coffee Indonesia", 20000),
                new Product("2", "Cà phê Ả Rập", 15000),
                new Product("3", "Coffee Latte", 18000)

        );

        model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
        return "products"; //không cần chữ .html
        //cơ chế giữ nguyên url cũ của doLogin
        //resubmission, nếu F5 lại thì... submit lại from, ko an toàn
        //đặc biệt với màn hình tạo mới
    }
}
