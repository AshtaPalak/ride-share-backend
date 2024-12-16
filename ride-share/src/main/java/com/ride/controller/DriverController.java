package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.model.Customer;
import com.ride.model.Driver;
import com.ride.service.CustomerService;
import com.ride.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/add")
	public Driver add(@RequestBody Driver driver) {
		return driverService.add(driver);
	}
	
	@GetMapping("/{id}")
	public Driver findById(@PathVariable(name = "id") int driverId) {
		return  driverService.getById(driverId);
	}
	
}
