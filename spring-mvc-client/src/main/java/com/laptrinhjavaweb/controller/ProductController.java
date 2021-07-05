package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listAll(Model model) {
		ModelAndView mav = new ModelAndView("products");
		List<Product> list = productDAO.findAll();
		model.addAttribute("listProduct", list);
		return mav;
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		productDAO.save(product);
		return "redirect:/";
	}

	@RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.GET)
	public String showFormForUpdate(@PathVariable int id, Model model) {
		Product product = productDAO.findById(id);
		model.addAttribute("product", product);
		return "product-form";
	}

	@RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product) {
		productDAO.save(product);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {
		productDAO.deleteById(id);
		return "redirect:/";
	}
}
