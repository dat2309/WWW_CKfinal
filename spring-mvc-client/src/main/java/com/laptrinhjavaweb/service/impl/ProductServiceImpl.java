package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemplate;
	private String url;

	@Autowired
	public ProductServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String url) {
		super();
		this.restTemplate = restTemplate;
		this.url = url;
	}

	public List<Product> findAll() {
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> list = responseEntity.getBody();
		return list;
	}

	public Product findById(int theId) {
		Product product = restTemplate.getForObject(url + "/" + theId, Product.class);
		return product;
	}

	public void save(Product product) {
		if (product.getId() == null) {
			restTemplate.postForObject(url, product, Product.class);
		} else {
			restTemplate.put(url, product);
		}

	}

	public void deleteById(int theId) {
		restTemplate.delete(url + "/" + theId);

	}

}
