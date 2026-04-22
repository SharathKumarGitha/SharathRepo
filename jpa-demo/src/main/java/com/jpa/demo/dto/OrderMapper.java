package com.jpa.demo.dto;

import org.springframework.stereotype.Component;

import com.jpa.demo.entity.Order;

@Component
public class OrderMapper {

	public OrderResponseDTO toDTO(Order order) {
		OrderResponseDTO dto = new OrderResponseDTO();
		dto.setId(order.getId());
		dto.setProduct(order.getProduct());
		dto.setUserName(order.getUser().getName());
		return dto;
	}
}