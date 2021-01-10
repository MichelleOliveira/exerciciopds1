package com.iftm.course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.course.dto.OrderDTO;
import com.iftm.course.repositories.OrderRepository;
import com.iftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderDTO> findAll() {
		return orderRepository.findAll().stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}
	
	public OrderDTO findById(Long id) {		
		return new OrderDTO(orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
	}
}
