package com.josh.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.josh.model.UserCart;
import com.josh.model.UserCartId;
import com.josh.service.UserCartService;

@RestController
@RequestMapping("/cart")
public class UserCartController {

	@Autowired
	private UserCartService userCartService;
	
	@GetMapping("/{userId}/{productId}")
	public UserCart getUserCartById(@PathVariable Long userId, @PathVariable Long productId) {
		return userCartService.getUserCartById(userId, productId);
	}
	@PostMapping("/add")
	public void addItemToCart(@RequestBody UserCart userCart) throws Exception {
		userCartService.addUserCart(userCart);
	}
	@GetMapping("/getcart")
	public List<UserCart> getUserCart() {
		return userCartService.getAllCartItems();
	}
	@DeleteMapping("/delete/{userId}/{productId}")
	public void deleteUser(@PathVariable Long userId, @PathVariable Long productId) {
		userCartService.deleteUserCart(new UserCartId(userId, productId));
	}
	@PutMapping("/update")
	public void updateItem(@RequestBody UserCart userCart) {
		userCartService.updateUserCart(userCart);
	}
}