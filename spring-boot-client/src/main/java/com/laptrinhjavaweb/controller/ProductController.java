package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping(value = "/all-product")
	public String allProductPage(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("listProduct", list);
		return "products";
	}

	@GetMapping(value = "/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}

	@GetMapping(value = "/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model model) {
		Product product = productService.findById(theId);
		model.addAttribute("product", product);
		return "product-form";
	}

	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/all-product";

	}

	@GetMapping(value = "/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		productService.deleteById(theId);
		return "redirect:/all-product";
	}
}
