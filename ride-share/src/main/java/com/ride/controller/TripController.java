package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.model.Trip;
import com.ride.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@PostMapping("/add/{customerId}/{driverId}")
	public Trip add(@RequestBody Trip trip, @PathVariable(name = "customerId") int cid, @PathVariable(name="driverId") int did) {
		System.out.println(trip);
		return tripService.add(trip,cid,did);
	}
	
	@GetMapping("/{id}")
	public Trip findById(@PathVariable(name = "id") int tripId) {
		return  tripService.getById(tripId);
	}
	
}
