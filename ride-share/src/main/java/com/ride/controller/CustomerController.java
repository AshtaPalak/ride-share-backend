package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.model.Customer;
import com.ride.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		return customerService.add(customer);
	}
	
	@GetMapping("/{id}")
	public Customer findById(@PathVariable(name = "id") int customerId) {
		return  customerService.getById(customerId);
	}
	
}
