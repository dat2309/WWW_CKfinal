package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public ProductServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String url) {
		restTemplate = theRestTemplate;
		crmRestUrl = url;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> list = responseEntity.getBody();
		return list;
	}

	@Override
	@Transactional
	public Product findById(int theId) {
		Product product = restTemplate.getForObject(crmRestUrl + "/" + theId, Product.class);
		return product;
	}

	@Override
	@Transactional
	public void save(Product product) {
		if (product.getId() == null) {
			restTemplate.postForObject(crmRestUrl, product, Product.class);
		} else {
			restTemplate.put(crmRestUrl, product);
		}

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		restTemplate.delete(crmRestUrl + "/" + theId);

	}

}
