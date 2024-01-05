package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccountController {
    @GetMapping("/account")
    public String getMethodName(Model model) {
        return "accountMain";
    }
    
}
