package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@Controller
public class HomeController {

	@Autowired
	IProductService productService;

	@GetMapping(value = "/")
	public String homePage(Model model) {
		return "index";
	}

	@GetMapping(value = "/products")
	public String productPage(Model model) {
		List<ProductDTO> list = productService.listAll();
		model.addAttribute("listProduct", list);
		return "products";
	}

	@GetMapping(value = "/add")
	public String addProductPage(@ModelAttribute("product") ProductDTO dto, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("product", new ProductDTO());
		return "add";
	}

}
