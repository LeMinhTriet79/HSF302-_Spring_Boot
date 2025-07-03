package com.giaolang.coffee.ntcoffee.controller;

import com.giaolang.coffee.ntcoffee.entity.Account;
import com.giaolang.coffee.ntcoffee.entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller //bean tồn tại sẵn trong ram, Tomcat, để handle cái request url gửi lên
//@RequestMapping("")
public class LoginController {

    //các hàm phục vụ nhu cầu login, map tới / /login, post cuủa login

    //load/trả trang login cho Thymeleaf -> render -> Tomcat -> browser
    @GetMapping({"/", "/login"})
    public String showLogin() {
        return "login";   //ghép tên trang + .html -> login.html đưa cho Thymeleaf; gửi kèm thêm data nếu cần - Model model
    }

    @PostMapping("/doLogin")
    public String doLoginAhihi(@RequestParam("user") String username, @RequestParam("pass") String password, RedirectAttributes redirectAttributes, HttpSession session) {

        //CHUẨN BỊ SẴN DANH SÁCH MÓN CAFE, LIST<>, ĐÍNH KÈM THEO THẰNG THÙNG CHỨA MODEL
        //THÙNG CHỨA SẼ CHỨA EMAIL + LIST
        //LẼ RA CODE NÀY CỦA SERVICE, LÀM SAU

        //model chính là 1 hộp gửi đồ, chứa đc nhiều đồ, đồ chính là các object nào đ bạn muốn cất trữ. mỖI MÓN ĐỒ KHI BỎ VÀO HỘP/HỘC TỦ, LUÔN ĐI KÈM 1 CÁI CHÌA KHOÁ
        //model.addAttribute("chìa khoá", món-đồ);
        //thông qua chìa khoá, ta mở tủ và lấy đc món đồ trở lại
        //y chang hộc/tủ giữ giỏ ở siêu thị
        //TU/HỘP CHỨA ĐỒ, CÓ ĐỔ BÊN TRONG LUÔN ĐC SHIP KÈM THEO
        //LỆNH CHUYỂN TRANG, LỆNH RETURN CÁI TRANG - VIEW
        //LÁT HỒI BÊN TRANG/VIEW, LÁY ĐỒ TRONG HỘP BÀY LÊN TRANG - RENDER
        //MVC, CONTROLLER NHẬN REQUEST, CHUẨN BỊ MODEL (DATA), GỬI CHO TRANG VIEW VÀ RENDER!!!


        //HỘP MODEL CÓ DATA, ĐI KÈM VỚI TRANG PRODUCTS.HTML
        //return "products";  //ko cần chữ .html
        //giữ nguyên url cũ của doLogin
        //resubmission, nếu F5 lại thì...submit lại form, ko an toàn
        //đặc biệt với màn hình tạo mới...

        //GỬI KÈM DATA CỦA CHỖ NÀY SANG GET MỚI, TỨC LÀ MODEL/THÙNG CỦA BÊN KIA, KÈM THÊM CÁC MÓN BÊN NÀY GỬI SANG!!!
        //redirectAttributes.addFlashAttribute("sentUser", username);

        //LẤY TỪ DB LÊN 1 ACCOUNT WHERE USER = USER, PASS = PASS ĐƯA VÀO VÀ CÓ ĐC ROLE 1, 2 TUỲ GÕ VÀO
        //HARD-CODED
        Account account;
        if (username.equalsIgnoreCase("admin"))
            account = new Account(username, password, 1);
        else
            account = new Account(username, password, 2);

        session.setAttribute("acc", account);

        //redirectAttributes.addFlashAttribute("products", productList);
        //2 món này đc gửi kèm theo GET PRODUCTS/, FILL THÊM VÀO THÙNG BÊN PRODUCTS
        return "redirect:/ngoctrinh";
        //GỌI URL MỚI HOÀN TOÀN TRÊN TRÌNH DUYỆT, GET MỚI HOÀN TOÀN!!!
        //GET MỚI HOÀN TOÀN, URL ĐC THAY ĐỔI
        //1 URL 1 HÀM MỚI TƯƠNG ỨNG -> HÀM GET CẦN CÓ ỨNG VỚI /ngoctrinh
    }
}
//NẾU DÙNG REDIRECT KO GIỮ LẠI ĐC MODEL ĐANG CÓ, VÌ REDIRECT LÀ GET MỚI URL MỚI
//MỖI GET MỚI SẼ CÓ 1 MODEL MỘT THÙNG CHỨA MỚI VÀ RỖNG

