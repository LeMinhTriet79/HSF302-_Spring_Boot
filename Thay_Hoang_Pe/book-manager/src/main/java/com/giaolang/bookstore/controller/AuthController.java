package com.giaolang.bookstore.controller;

import com.giaolang.bookstore.entity.Account;
import com.giaolang.bookstore.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AccountService accountService;

    @GetMapping({"/", "/login"})
    public String showLogin() {
        return "login"; //login.html
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession ses) {
        ses.invalidate();  //xoá biến loggedInUser trong vùng quảng trường thay vì chờ 30phut default
        return "redirect:/login"; //login.html
    }

    @PostMapping("/auth")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {

        Account acc = accountService.authenticate(email, password);
        //hoặc null hoặc khác null - tức là match email và pass
        //null chả biết sai cái gì, vì có thể là sai email, sai pass, sai cả 2, role member, active false
        if (acc == null) {
            //vòng về gõ lại login hoy
            //gửi kèm câu chửi
            model.addAttribute("error", "Invalid credentials!!!");
            //                      String error = "Invalid credentials";
            return "login";
        }

        //login thành công, cất thông tin login lâu dài, để phân quyền ở các trang, để chặn gõ trực tiếp url bypass login...
        //CẤT VÀO 1 NƠI MÀ MỌI TRANG CỦA USER NÀY CÙNG NHÌN THẤY, CÙNG XÀI
        //THÙNG SESSION NÀY LÂU DÀI HƠN THÙNG MODEL - MODEL CHỈ CÓ REQUEST, GỬI THÙNG, RETURN, HẾT THÙNG - REQUEST SCOPE
        //SESSION: MỌI TRANG ĐỀU ADD, DÙNG, DEFAULT 30 PHÚT
        //GIỐNG QUẢNG TRƯỜNG, SẢNH, TỦ ĐỰNG ĐỒ 30 PHÚT, MN CÙNG ĐẾN THAM GIA...
        //SESSION SCOPE
        //MỖI USER SẼ CÓ 1 SESSION, SERVER CÓ NHIỀU QUẢNG TRƯỜNG
        session.setAttribute("loggedInUser", acc); //thùng model lâu dài hơn, dành cho từng acc
        //ram tomcat: Account loggedInUser = acc;

        return "redirect:/books"; //gọi trang Book lên đấy, qua url, ko return tên trang
             //đổi url, tránh lỗi resubmission khi F5
    }

}
