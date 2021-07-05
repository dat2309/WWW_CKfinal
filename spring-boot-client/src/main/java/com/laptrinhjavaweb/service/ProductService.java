package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.Product;

public interface ProductService {
	public List<Product> findAll();

	public Product findById(int theId);

	public void save(Product product);

	public void deleteById(int theId);
}
