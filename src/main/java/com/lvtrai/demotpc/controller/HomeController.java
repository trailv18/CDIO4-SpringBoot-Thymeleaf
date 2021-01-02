package com.lvtrai.demotpc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lvtrai.demotpc.model.Product;
import com.lvtrai.demotpc.service.ProductService;


@Controller
public class HomeController {
		
	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value={"/","/home"})
	public String index(Model model) {		
		List<Product> products = productService.findFirstProducts();
		model.addAttribute("products", products);
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {		
		return "adminHome";
	}

	
}
