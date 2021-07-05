package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setDescription(dto.getDescription());
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		return entity;
	}

	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		entity.setDescription(dto.getDescription());
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		return entity;
	}

	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setDescription(entity.getDescription());
		dto.setImage(entity.getImage());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		return dto;
	}
}
