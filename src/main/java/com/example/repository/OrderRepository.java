package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderData;

public interface OrderRepository extends JpaRepository<OrderData, Long> {
	
	
}
