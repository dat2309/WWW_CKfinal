package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
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
	ProductConverter productConverter;

	@Override
	public ProductDTO saveProduct(ProductDTO dto) {
		ProductEntity productEntity = new ProductEntity();
		if (dto.getId() != null) {
			ProductEntity oldProductEntity = productRepository.findOne(dto.getId());
			productEntity = productConverter.toEntity(dto, oldProductEntity);
		} else {
			productEntity = productConverter.toEntity(dto);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		productEntity.setCategory(categoryEntity);
		productEntity = productRepository.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public void deleteProduct(long[] ids) {
		for (long item : ids) {
			productRepository.delete(item);
		}

	}

	@Override
	public List<ProductDTO> listAll() {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		List<ProductEntity> entities;
		entities = productRepository.findAll();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

}
