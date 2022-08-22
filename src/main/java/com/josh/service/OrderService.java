package com.josh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.josh.model.Product;
import com.josh.model.Orders;
import com.josh.repository.OrdersRepository;
import com.josh.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}
	
	public Orders getOrderById(Long id) {
		return ordersRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+id) );
	}
	
	public void addOrder(Orders order) {
		ordersRepository.save(order);
	}
	
	public Orders updateOrder(Orders order) {
		ordersRepository
		.findById(order.getOrderId())
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+order.getOrderId()) );
	return ordersRepository.save(order);
	}
	
	public void deleteOrder(Long id) {
		ordersRepository.deleteById(id);
	}
	
	
	
	public void addProductToOrder(Long orderId, Long productId) throws Exception {
		Orders order = ordersRepository.findById(orderId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+orderId));
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found with id : "+productId));
		order.getProducts().add(product);
		product.getOrders().add(order);
		ordersRepository.save(order);
		productRepository.save(product);
	}

}
