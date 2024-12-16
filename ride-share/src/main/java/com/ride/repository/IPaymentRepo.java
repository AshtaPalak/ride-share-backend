package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Payment;

public interface IPaymentRepo extends JpaRepository<Payment, Integer>{

}
