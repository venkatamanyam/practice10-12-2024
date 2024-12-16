package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CustomerData;

public interface CustomerRepository extends JpaRepository<CustomerData, Long> {
}

