package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Trip;

public interface ITripRepo extends JpaRepository<Trip, Integer>{

}
