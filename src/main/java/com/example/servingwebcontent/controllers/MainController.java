package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class MainController {
	private final ProductService productService;
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "home page");
		return "home";
	}

}