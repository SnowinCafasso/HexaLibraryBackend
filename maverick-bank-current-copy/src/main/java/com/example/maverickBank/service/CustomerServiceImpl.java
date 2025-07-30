package com.example.maverickBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.maverickBank.dto.CustomerRegistrationDto;
import com.example.maverickBank.entity.AuthUser;
import com.example.maverickBank.entity.Customer;
import com.example.maverickBank.repository.AuthUserRepository;
import com.example.maverickBank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public ResponseEntity<?> registerCustomer(CustomerRegistrationDto dto) {
        // Check if email already exists
        if (authUserRepository.findByEmail(dto.getCustomerEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already in use.");
        }

        // Create and save Customer
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhoneNumber(dto.getCustomerPhoneNumber());
        customer.setGender(dto.getGender());
        customer.setDOB(dto.getDob());

        // Set customerType or assign default
        if (dto.getCustomerType() != null && !dto.getCustomerType().isEmpty()) {
            customer.setCustomerType(dto.getCustomerType());
        } else {
            customer.setCustomerType("individual");  // Default type
        }

        Customer savedCustomer = customerRepository.save(customer);

        // Create and save AuthUser
        AuthUser authUser = new AuthUser();
        authUser.setEmail(dto.getCustomerEmail());
        authUser.setPassword(dto.getPassword()); // Password is not encrypted as requested
        authUser.setUserType("customer");
        authUser.setUserId(savedCustomer.getCustomerId());

        authUserRepository.save(authUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }
}
