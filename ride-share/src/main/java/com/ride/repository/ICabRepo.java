package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Cab;

public interface ICabRepo extends JpaRepository<Cab, Integer>{

}
