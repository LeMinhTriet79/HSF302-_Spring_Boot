package hsf302.sp25.se171588.controller;

import hsf302.sp25.se171588.entity.SonyAccounts;
import hsf302.sp25.se171588.service.AccountsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountsController {
    @Autowired
    private AccountsService accountsService;
    @GetMapping({"/", "login"})
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/do-login")
    public String doLogin(@RequestParam("email") String email,
                          @RequestParam("phone") String phone,
                          Model model, HttpSession session) {
        SonyAccounts account = accountsService.findByEmail(email);
        if(account != null && account.getPhone().equals(phone)) {
            int role = account.getRole();
            SonyAccounts.AccountStatus status=account.getStatus();

            if ((role == 1 || role == 3) && status.equals(SonyAccounts.AccountStatus.ACTIVE)) {
                session.setAttribute("role", role);
                return "redirect:/products";
            } else {
                model.addAttribute("error", "You don't have permission to access this page.");
                return "login";
            }

        } else {
            model.addAttribute("error", "Email or Phone is wrong");
            return "login";
        }
    }

}
