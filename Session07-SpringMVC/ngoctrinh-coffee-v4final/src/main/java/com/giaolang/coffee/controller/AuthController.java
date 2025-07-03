package com.giaolang.coffee.controller;

import com.giaolang.coffee.entity.Account;
import com.giaolang.coffee.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("account") Account account, Model model) {
        Account acc = accountService.checkLogin(account.getUsername(), account.getPassword());
        if (acc != null) {
            return "redirect:/products";
        } else {
            model.addAttribute("error", "Wrong username or password!");
            return "login";
        }
    }
}
