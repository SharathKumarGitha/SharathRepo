package com.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.dto.OrderResponseDTO;
import com.jpa.demo.entity.Order;
import com.jpa.demo.service.OrderService;

@RestController
@RequestMapping("/com/jpa")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value ="/save",consumes = "application/json")
	@ResponseBody
	public OrderResponseDTO save(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@GetMapping("/getAllOrders")
	@ResponseBody
	public List<OrderResponseDTO> getAllOrderDetails() {
		return orderService.getOrdersList();
	}
	
	
	@GetMapping("/{orderid}")
	public Order getOrderById(@PathVariable("orderid") Long id)
	{
		return orderService.getSingleOrder(id);
	}

}
