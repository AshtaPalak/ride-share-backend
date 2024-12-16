package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer>{

}
