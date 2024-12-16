package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class OrderDataDTO {
    private Long id;
    private String product;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CustomerDataDTO customerDTO;
    
	public CustomerDataDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDataDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public OrderDataDTO(Long id, String product, CustomerDataDTO customerDTO) {
		super();
		this.id = id;
		this.product = product;
		this.customerDTO = customerDTO;
	}
	
	
    
    
}
