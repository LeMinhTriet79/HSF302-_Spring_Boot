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

        //model chính là 1 cái hộp gửi đồ, chứ đc nhiều đồ, đồ chính là các object mà bào đc bạn muốn cất trữ,
        //mỗi món đồ jhu bỉ vài hộp/hộc tủ, luôn đi kèm 1 chùa khóa

        //Thông qua chìa khóa, ta mở tủ và ấy đc món đồ trở lại
        //y chang hộc tủ giữ đồ ở sưu thị
        //tủ hộp chứa đồ, đã có đồ rồi, có đồ bên trong luôn đc ship kèm theo
        //Lệnh chuyển trang, lệnh return cái trang - view
        //lát hồi bên trang/ view lấy đồ trong hộp bày lên trang - render
        //MVC, Controller nhận request, chuẩn bị model(data) gửi cho trang view và render
        //Hộp model có data, đi kèm với trang products.html
        model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
        return "products"; //không cần chữ .html
        //cơ chế giữ nguyên url cũ của doLogin
        //resubmission, nếu F5 lại thì... submit lại from, ko an toàn
        //đặc biệt với màn hình tạo mới
    }
}
