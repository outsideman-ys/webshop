package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.repo.ProductRepository;
import com.example.servingwebcontent.services.ProductService;
import com.example.servingwebcontent.models.UserData;
import com.example.servingwebcontent.repo.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class AccountController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserDataRepository userDataRepos;

    @GetMapping("/account")
    public String getMethodName(Model model) {
        Iterable<UserData> userData = userDataRepos.findAll();
        model.addAttribute("users", userData);
        return "accountMain";
    }

    @GetMapping("/account/add-product")
    public String addProduct(Model model) {
        return "add-product";
    }

    @GetMapping("/account/select-changeable-product")
    public String selectChangeableProduct(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "select-changeable-product";
    }

    @GetMapping("/account/edit-product/{id}")
    public String pageProduct(@PathVariable(value = "id") long id, Model model) {
        if(!productRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Product> product = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        product.ifPresent(res::add);
        model.addAttribute("product", res);
        return "edit-product";
    }

    @GetMapping("/account/select-removable-product")
    public String selectRemovableProduct(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "select-removable-product";
    }

    @PostMapping("/account/add-product")
    public String transferProductToBase(@RequestParam String name, @RequestParam int price, @RequestParam String description,
                                        Model model){
        Product product = new Product(name, price, description);
        productRepository.save(product);
        return "redirect:/account";
    }

    @PostMapping("/account/edit-product/{id}")
    public String editProductInBase(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam int price,
                                    @RequestParam String description, Model model){
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productRepository.save(product);
        return "redirect:/account";
    }

    @PostMapping("/account/select-removable-product/{id}")
    public String removeProductInBase(@PathVariable(value = "id") long id, Model model){
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return "redirect:/account";
    }
}
