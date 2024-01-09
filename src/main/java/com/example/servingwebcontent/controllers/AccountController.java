package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.UserData;
import com.example.servingwebcontent.repo.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccountController {

    @Autowired
    private UserDataRepository userDataRepos;

    @GetMapping("/account")
    public String getMethodName(Model model) {
        Iterable<UserData> userData = userDataRepos.findAll();
        model.addAttribute("users", userData);
        return "accountMain";
    }
    
}
