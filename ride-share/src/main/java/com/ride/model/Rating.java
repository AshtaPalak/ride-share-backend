package com.ride.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Driver driver;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Trip trip;
	private int rating;
	private String feedback;

}
