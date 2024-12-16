package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Driver;

public interface IDriverRepo extends JpaRepository<Driver, Integer>{

}
