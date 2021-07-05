package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@CrossOrigin
@RestController
public class ProductAPI {

	@Autowired
	IProductService productService;

	@GetMapping(value = "/product")
	public List<ProductDTO> listAll() {
		List<ProductDTO> list = productService.listAll();
		return list;
	}

	@PostMapping(value = "/product")
	public ProductDTO createProduct(@RequestBody ProductDTO model) {
		return productService.saveProduct(model);
	}

	@PutMapping(value = "/product/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO model, @PathVariable long id) {
		model.setId(id);
		return productService.saveProduct(model);
	}

	@DeleteMapping(value = "/product")
	public void deleteProduct(@RequestBody long[] ids) {
		productService.deleteProduct(ids);
	}
}
