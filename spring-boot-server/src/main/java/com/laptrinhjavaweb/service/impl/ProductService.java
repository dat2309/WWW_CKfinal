package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void save(ProductEntity entity) {
		productRepository.save(entity);

	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);

	}

	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity findById(int id) {
		Optional<ProductEntity> result = productRepository.findById(id);
		ProductEntity entity = null;
		if (result.isPresent()) {
			entity = result.get();
		} else {
			throw new RuntimeException("Did not find product id - " + id);
		}
		return entity;
	}

}
