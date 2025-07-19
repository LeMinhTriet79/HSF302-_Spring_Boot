package sum25.se181979.pehsf302trialexamse181979.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyAccount;
import sum25.se181979.pehsf302trialexamse181979.service.SonyAccountService;

@Controller
public class AuthController {
    @Autowired
    private SonyAccountService accountService;

    // Trang login (GET)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html trong templates
    }

    // Xử lý login (POST)
    @PostMapping("/login")
    public String login(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        SonyAccount acc = accountService.login(phone, password);
        if (acc == null || (acc.getRoleID() != 1 && acc.getRoleID() != 2)) {
            model.addAttribute("error", "You do not have permission to access this function!");
            return "login";
        }
        // Đăng nhập thành công, lưu vào session
        session.setAttribute("user", acc);
        return "redirect:/products";
    }

    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
