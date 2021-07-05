package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.service.IProductService;

@CrossOrigin
@RestController
public class ProductAPI {

	@Autowired
	IProductService productService;

	@Autowired
	public ProductAPI(IProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping(value = "/product")
	public List<ProductEntity> listAll() {
		return productService.findAll();
	}

	@GetMapping(value = "/product/{productId}")
	public ProductEntity getProduct(@PathVariable int productId) {
		ProductEntity entity = productService.findById(productId);
		if (entity == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		return entity;
	}

	@PostMapping(value = "/product")
	public ProductEntity createProduct(@RequestBody ProductEntity entity) {
		entity.setId(0);
		productService.save(entity);
		return entity;
	}

	@PutMapping(value = "/product")
	public ProductEntity updateProduct(@RequestBody ProductEntity entity) {
		productService.save(entity);
		return entity;
	}

	@DeleteMapping(value = "/product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		ProductEntity entity = productService.findById(productId);
		if (entity == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		productService.deleteById(productId);

		return "Deleted product id - " + productId;
	}
}
