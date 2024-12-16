package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Rating;

public interface IRatingRepo extends JpaRepository<Rating, Integer>{

}
