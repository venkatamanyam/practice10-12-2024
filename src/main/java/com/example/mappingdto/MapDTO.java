package com.example.mappingdto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.dto.CustomerDataDTO;
import com.example.dto.OrderDataDTO;
import com.example.entity.CustomerData;
import com.example.entity.OrderData;
@Component
public class MapDTO {
	
	public CustomerDataDTO mapToDTO(CustomerData customer, boolean includeOrders) {
        List<OrderDataDTO> orderDTOs = null;

        if (includeOrders && customer.getOrders().size()>0) {
            orderDTOs = customer.getOrders().stream()
                .map(order -> new OrderDataDTO(order.getId(), order.getProduct(), null))
                .collect(Collectors.toList());
        }

        return new CustomerDataDTO(customer.getId(), customer.getName(), orderDTOs);
    }
	
	public OrderDataDTO mapToDTO(OrderData order, boolean includeCustomer) {
        CustomerDataDTO customerDTO = null;

        if (includeCustomer && order.getCustomer() != null) {
            customerDTO = new CustomerDataDTO(order.getCustomer().getId(), order.getCustomer().getName(), null);
        }

        return new OrderDataDTO(order.getId(), order.getProduct(), customerDTO);
    }


}
