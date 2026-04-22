package com.jpa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.dto.OrderMapper;
import com.jpa.demo.dto.OrderResponseDTO;
import com.jpa.demo.entity.Order;
import com.jpa.demo.repository.OrderRepo;
import com.jpa.demo.repository.UserRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepository;

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private OrderMapper orderMapper;

	public OrderResponseDTO createOrder(Order orderRequest) {

		Long userId = orderRequest.getUser().getId();

		com.jpa.demo.entity.User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));

		// 🔁 maintain both sides
		user.getOrders().add(orderRequest);
		orderRequest.setUser(user);

		 Order saved_order=orderRepository.save(orderRequest);
		 
		 return orderMapper.toDTO(saved_order);
	}

	public List<OrderResponseDTO> getOrdersList() {
		
		
		return orderRepository.
				findAll().stream().
				map(order ->{
					
					OrderResponseDTO dto=new OrderResponseDTO();
					
					dto.setId(order.getId());
					
					dto.setProduct(order.getProduct());
					
					dto.setUserName(order.getUser().getName());
					
					return dto;
				}).collect(Collectors.toList());
	}

	public Order getSingleOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("order not found with given id"));
	}

}
