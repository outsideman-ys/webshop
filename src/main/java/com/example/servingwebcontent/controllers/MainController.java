package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.repo.ProductRepository;
import com.example.servingwebcontent.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	private final ProductService productService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "home page");
		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "home";
	}

	@GetMapping("/home/{id}")
	public String pageProduct(@PathVariable(value = "id") long id, Model model) {
		if(!productRepository.existsById(id)) {
			return "redirect:/";
		}
		Optional<Product> product = productRepository.findById(id);
		ArrayList<Product> res = new ArrayList<>();
		product.ifPresent(res::add);
		model.addAttribute("product", res);
		return "page-product";
	}

}