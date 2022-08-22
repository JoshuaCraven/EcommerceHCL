package com.josh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.josh.model.Product;
import com.josh.model.User;
import com.josh.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}
	
	
	public User updateUser(User user) {
		repo.findById(user.getUserId())
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"not product found with Id: "+user.getUserId()));
		return repo.save(user);
	}

}
