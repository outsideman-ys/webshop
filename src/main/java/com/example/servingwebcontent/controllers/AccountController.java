package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.repo.ProductRepository;
import com.example.servingwebcontent.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/account")
    public String getMethodName(Model model) {
        return "accountMain";
    }

    @GetMapping("/account/add-product")
    public String addProduct(Model model) {
        return "add-product";
    }

    @PostMapping("/account/add-product")
    public String transferProductToBase(@RequestParam String name, @RequestParam int price, @RequestParam String description,
                                        Model model){
        Product product = new Product(name, price, description);
        productRepository.save(product);
        return "redirect:/account";
    }
}
