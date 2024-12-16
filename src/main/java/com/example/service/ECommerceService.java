package com.example.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerDataDTO;
import com.example.dto.OrderDataDTO;
import com.example.entity.CustomerData;
import com.example.entity.OrderData;
import com.example.mappingdto.MapDTO;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;

@Service
public class ECommerceService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private MapDTO map;

        // For Bidirectional Relationship
    public String saveCustomer(CustomerDataDTO customerDTO) {
    	
    	CustomerData customer=new CustomerData();
    	
    	BeanUtils.copyProperties(customerDTO, customer);
                
    	    CustomerData customerData = customerRepository.save(customer);
                
                if(customerData!=null)
            	{
                return "success";
            	}
                
                else return "failed";
                
    }
    public String saveOrder(OrderDataDTO orderDTO,Long id) {
    	
    	CustomerData customer = customerRepository.findById(id).orElse(null);
    	if(customer!=null)
    	{
    		OrderData order=new OrderData();
    		
    		order.setCustomer(customer);
    		
    	    BeanUtils.copyProperties(orderDTO,order);
    	    
    	    orderRepository.save(order);
    	    
            return "success";
        }
    	else return "failed";
}
    
    

    
    

    
    
    public OrderDataDTO getOrder(Long id, boolean includeCustomer) {
        OrderData order = orderRepository.findById(id).orElse(null);
        return order != null ? map.mapToDTO(order, includeCustomer) : null; // Or throw an exception
    }

    public List<OrderDataDTO> getAllOrders(boolean includeCustomer) {
        List<OrderData> orders = orderRepository.findAll();
        return orders.stream()
            .map(order -> map.mapToDTO(order, includeCustomer))
            .collect(Collectors.toList());
    }
    
    
    
   public CustomerDataDTO getCustomer(Long id, boolean includeOrders) {
        CustomerData customer = customerRepository.findById(id).orElse(null);
        return customer != null ? map.mapToDTO(customer, includeOrders) : null; // Or throw an exception
    }

    public List<CustomerDataDTO> getAllCustomers(boolean includeOrders) {
        List<CustomerData> customers = customerRepository.findAll();
        return customers.stream()
            .map(customer -> map.mapToDTO(customer, includeOrders))
            .collect(Collectors.toList());
    }
    
    
    
    
    
    
  //without any condition
    public CustomerData getCustomer(Long id)
    {
    	return customerRepository.findById(id).get();
    }
    
public OrderData getOrder(Long id) {
		
		return orderRepository.findById(id).get();
	}
}
