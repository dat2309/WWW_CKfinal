package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface IProductService {
	public void save(ProductEntity entity);
	
	public void deleteById(int id);

	public List<ProductEntity> findAll();
	
	public ProductEntity findById(int id);
}
