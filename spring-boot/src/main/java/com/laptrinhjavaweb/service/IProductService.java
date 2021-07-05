package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	ProductDTO saveProduct(ProductDTO dto);

	void deleteProduct(long[] ids);

	List<ProductDTO> listAll();
}
