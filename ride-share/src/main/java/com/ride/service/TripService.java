package com.ride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.model.Driver;
import com.ride.model.Trip;
import com.ride.repository.ICustomerRepo;
import com.ride.repository.IDriverRepo;
import com.ride.repository.ITripRepo;

@Service
public class TripService {
	
	@Autowired
	private ITripRepo tripRepository;
	@Autowired
	private ICustomerRepo customerRepository;
	@Autowired
	private IDriverRepo driverRepository;
	
	public Trip add(Trip trip,int customerId,int driverId) {
		trip.setDriver(driverRepository.findById(driverId).get());
		trip.setCustomer(customerRepository.findById(customerId).get());
		System.out.println(trip);
		return tripRepository.saveAndFlush(trip);
	}
	
	public Trip getById(int id) {
		return tripRepository.findById(id).get();
	}
	

}
