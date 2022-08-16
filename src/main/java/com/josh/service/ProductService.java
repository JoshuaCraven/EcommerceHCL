package com.josh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.josh.model.Product;
import com.josh.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	public Optional<Product> getProductById(int id){
		return repo.findById(id);
	}
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
	public void addProduct(Product product) {
		repo.save(product);
	}
	public Product updateProduct(Product product) {
		repo.findById(product.getProductId())
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"not product found with Id: "+product.getProductId()));
		return repo.save(product);
	}
}
