package com.example.thi_thu.controller;

import com.example.thi_thu.entity.Account;
import com.example.thi_thu.service.AccountService;
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

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Account acc = accountService.login(email, password);
        if (acc != null && (acc.getRole() == 1 || acc.getRole() == 3)) {
            session.setAttribute("user", acc);
            return "redirect:/movies";
        } else {
            model.addAttribute("msg", "You have no permission to access this function!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}