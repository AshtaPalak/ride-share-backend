package com.ride.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.model.Rating;
import com.ride.repository.IRatingRepo;
import com.ride.repository.ITripRepo;

@Service
public class RatingsService {
	
	@Autowired
	public IRatingRepo ratingRepository;
	
	@Autowired
	public ITripRepo tripRepository;

	public Rating add(Rating rating, int tripId) {
		rating.setTrip(tripRepository.findById(tripId).get());
		return ratingRepository.saveAndFlush(rating);
	}
	public Rating getById( int tripId) {
		return ratingRepository.findById(tripId).get();
		
	}

	
}
