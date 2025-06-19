package org.minhtriet.coffee.ntcoffee.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
