package com.ride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.model.Customer;
import com.ride.repository.ICabRepo;
import com.ride.repository.ICustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private ICustomerRepo customerRepository;
	
	public Customer add(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	
	public Customer update(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	
	public Customer getById(int id) {
		return customerRepository.findById(id).get();
	}
	

}
