package com.ride.model;

import java.awt.Point;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.ride.enums.RideStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Driver driver;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	private RideStatus rideStatus;
	private double sourceLongitude;
	private double sourceLatitude;
	private double destinationLongitude;
	private double destinationLatitude;
	@CreationTimestamp
	private LocalDate createdAt;
	

}
