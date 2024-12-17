package com.ride.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ride.dto.LoginCustomerDto;
import com.ride.dto.RegisterCustomerDto;
import com.ride.dto.UpdateCustomerDto;
import com.ride.model.Customer;
import com.ride.repository.ICabRepo;
import com.ride.repository.ICustomerRepo;

@Service
public class CustomerService {
	private final ICustomerRepo customerRepository;
	private final AuthenticationManager authenticationManager;
	
	private final PasswordEncoder passwordEncoder;
	
	public CustomerService(
		ICustomerRepo customerRespository,
		AuthenticationManager authenticationManager,
		PasswordEncoder passwordEncoder
		
) {
		this.customerRepository= customerRespository;
		this.authenticationManager= authenticationManager;
		this.passwordEncoder= passwordEncoder;
	}
	
	public Customer findByUsername(String username) {
        return customerRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
	
	public Customer add(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	
	public Customer update(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	
	public Customer getById(int id) {
		return customerRepository.findById(id).get();
	}
	
	

	public Customer signup(RegisterCustomerDto input) {
		Customer user=new Customer();
    	long timestamp = Instant.now().toEpochMilli();
    	System.out.println(passwordEncoder.encode(input.getPassword()));
    	user.setEmail(input.getEmail());
    	user.setName(input.getName());
    	user.setPhone(input.getPhone());
    	user.setPassword(passwordEncoder.encode(input.getPassword()));

//		String verificationToken = UUID.randomUUID().toString();
//		user.setVerificationToken(verificationToken);
//		System.out.println(verificationToken);
//		String verificationLink = "http://localhost:8085/users/verify-email?token=" + verificationToken;
//		emailClient.sendEmail(new EmailRequest(
//				user.getEmail(),
//				"Click the link to verify your email: " + verificationLink,
//				"Verify Your Email Address"
//		));
        return customerRepository.save(user);
    }
	
	public Customer authenticate(LoginCustomerDto input) {
    	Customer user = customerRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
//    	Collection<GrantedAuthority> authorities = mapRolesToAuthorities(List.of(user.getRoles()));
//    	System.out.println(authorities);
    	System.out.println("---------------------");
    	 authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return customerRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
    public List<Customer> allUsers() {
        List<Customer> users = new ArrayList();
        customerRepository.findAll().forEach(users::add);
        customerRepository.findAll().forEach(System.out::println);
        return users;
    }
    
    
    public Customer updateUser(String email, UpdateCustomerDto newUser) {
    	Customer user = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    	user.setName(newUser.getName());
    	user.setName(newUser.getName());
    	user.setPhone(newUser.getPhone());
//    	user.setProfileImg(newUser.getProfileImgUrl());
    	return customerRepository.save(user);
    }
	}
	