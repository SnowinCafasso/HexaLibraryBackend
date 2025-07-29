package com.example.maverickBank.controller;

import com.example.maverickBank.dto.CustomerRegistrationDto;
import com.example.maverickBank.entity.Customer;
import com.example.maverickBank.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Only registration allowed now
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegistrationDto registrationDto) {
        return customerService.registerCustomer(registrationDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
