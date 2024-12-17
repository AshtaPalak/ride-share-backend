package com.ride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmail(String username);

}
