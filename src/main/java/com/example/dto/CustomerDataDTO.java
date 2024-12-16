package com.example.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CustomerDataDTO {
	
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderDataDTO> orders; 
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<OrderDataDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDataDTO> orders) {
		this.orders = orders;
	}
	public CustomerDataDTO(Long id, String name, List<OrderDataDTO> orders) {
		super();
		this.id = id;
		this.name = name;
		this.orders = orders;
	}
	

}
