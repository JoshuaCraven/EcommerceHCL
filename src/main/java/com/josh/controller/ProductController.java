package com.josh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.josh.common.UserConstant;
import com.josh.model.Product;
import com.josh.model.User;
import com.josh.repository.ProductRepository;
import com.josh.repository.UserRepository;
import com.josh.service.ProductService;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
    private ProductRepository repository;
	
	@Autowired
	private ProductService service;


	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/add")
    public String addProductToShop(@RequestBody Product product) {
        service.addProduct(product);
        return ""+product.getProductName()+" Product added succesfully";
    }
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/update/{ProductId}") //THIS IS BROKEN!
	public String UpdateByProductId(@PathVariable Integer ProductId, @RequestBody Product product) {
		service.getProductById(ProductId);
		service.addProduct(product);
		return "Product was successfully Deleted.";
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/deleteproduct/{ProductId}")
	public String DeleteByProductId(@PathVariable Integer ProductId) {
		service.deleteProduct(ProductId);
		return "Product Successfully Deleted.";
	}
	//No Authorize because both Admin and User should be able to access
	@GetMapping("/getallproducts")
	public List<Product> listAllProducts(){
		return service.getAllProducts();
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/updateproduct/{ProductId}")
	public String updateProductById(@PathVariable Integer ProductId, @RequestBody Product product){
		service.updateProduct(product);
		return "Product updated.";
	}
	
	
}
