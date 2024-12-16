package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDataDTO;
import com.example.dto.OrderDataDTO;
import com.example.entity.CustomerData;
import com.example.entity.OrderData;
import com.example.service.ECommerceService;

@RestController
public class ECommerceController {

    @Autowired
    private ECommerceService eCommerceService;

    

    @PostMapping("/save-customer")
    public String saveCustomerData(@RequestBody CustomerDataDTO customerDTO) {
    	return eCommerceService.saveCustomer(customerDTO);
         
    }
    
    @PostMapping("/save-order/{customerid}")
    public String saveOrderData(@RequestBody OrderDataDTO orderDTO,@PathVariable Long id) {
    	return eCommerceService.saveOrder(orderDTO,id);
         
    }
    
    @GetMapping("/customer/{customerid}")
    public CustomerDataDTO showCustomerBidirectional(@PathVariable Long id) {
        return eCommerceService.getCustomer(id,true);
       
    }
    @GetMapping("/order/{orderid}")
    public OrderDataDTO showOrderBidirectional(@PathVariable Long id) {
        return eCommerceService.getOrder(id,true);
       
    }
}
