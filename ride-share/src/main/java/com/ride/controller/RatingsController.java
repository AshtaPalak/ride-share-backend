package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.model.Rating;
import com.ride.service.RatingsService;

@RestController
@RequestMapping("/rating")
public class RatingsController {

	@Autowired
	public RatingsService ratingsService;
	
	@PostMapping("/add/{trip_id}")
	public Rating add(@RequestBody Rating rating, @PathVariable(name="trip_id") int tripId) {
		return ratingsService.add(rating, tripId);
	}
	@GetMapping("/{id}")
	public Rating findById(@PathVariable(name="id")int tripId) {
		return ratingsService.getById(tripId);
	}
	
}
