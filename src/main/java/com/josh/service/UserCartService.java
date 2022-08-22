package com.josh.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.josh.model.UserCart;
import com.josh.model.UserCartId;
import com.josh.repository.UserCartRepository;

@Service
public class UserCartService {
	
	@Autowired
	private UserCartRepository userCartRepository;
	
	public List<UserCart> getAllCartItems() {
		return userCartRepository.findAll();
	}
	
	public UserCart getUserCartById(Long userId, Long productId) {
		return userCartRepository.findById(new UserCartId(userId,productId))
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"UserCart not found with user id: " 
						+ userId + " and product id: " + productId) );
	}
	
	public void addUserCart(UserCart userCart) {
		userCartRepository.save(userCart);
	}

	public UserCart updateUserCart(UserCart userCart) {
		userCartRepository
			.findById(userCart.getUserCartId())
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"UserCart not found with user id: "+userCart.getUserCartId()) );
		return userCartRepository.save(userCart);
	}
	
	public void deleteUserCart(UserCartId id) {
		userCartRepository.deleteById(id);
	}

}