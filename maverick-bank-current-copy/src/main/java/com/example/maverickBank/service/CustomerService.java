package com.example.maverickBank.service;

import org.springframework.http.ResponseEntity;
import com.example.maverickBank.dto.CustomerRegistrationDto;
import com.example.maverickBank.entity.Customer;

public interface CustomerService {
	//Get Customer by ID 
    Customer getCustomerById(Long id);
    
    //Create Customer with Authentication
    ResponseEntity<?> registerCustomer(CustomerRegistrationDto registrationDto);
    
    //Update Customer
    Customer saveCustomer(Customer customer);
    
    //Delete a Customer and its associations
    void deleteCustomerById(Long id);
    
}
