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

import com.josh.model.Orders;
import com.josh.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public Orders getorder(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/orderlist")
	public List<Orders> orderlist(){
		return orderService.getAllOrders();
	}
	
	@PostMapping("/add")
	public void addorder(@RequestBody Orders order) {
		orderService.addOrder(order);
	}
	
	@PutMapping("/update")
	public void updateorder(@RequestBody Orders order) {
		orderService.updateOrder(order);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteorder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}
	
	@PostMapping("/{orderId}/product/{productId}")
	public void addproductbyidtoorder(@PathVariable Long orderId, @PathVariable Long productId)throws Exception {
		orderService.addProductToOrder(orderId, productId);
	}
	
	
	

}