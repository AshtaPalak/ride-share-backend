package com.ride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.model.Driver;
import com.ride.repository.IDriverRepo;

@Service
public class DriverService {
	
	@Autowired
	private IDriverRepo driverRepository;
	
	
	public Driver add(Driver driver) {
		return driverRepository.saveAndFlush(driver);
	}
	
	public Driver getById(int id) {
		return driverRepository.findById(id).get();
	}
	
	

}
