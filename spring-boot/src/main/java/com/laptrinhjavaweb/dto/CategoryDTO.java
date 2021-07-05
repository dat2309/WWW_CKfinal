package com.laptrinhjavaweb.dto;

import java.util.List;

public class CategoryDTO {
	private Long id;
	private String name;
	private String code;
	private List<ProductDTO> products;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long id, String name, String code, List<ProductDTO> products) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
