package com.example.maverickBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.maverickBank.entity.Admin;
import com.example.maverickBank.entity.Customer;
import com.example.maverickBank.service.AdminService;
import com.example.maverickBank.service.CustomerService;
import com.example.maverickBank.service.EmployeeService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    //Create an Admin
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }
    
    //Verify the Customer
    @PutMapping("/verify-customer/{id}")
    public ResponseEntity<String> verifyCustomer(@PathVariable Long id) {
		Customer customer = customerService.getCustomerById(id);
        customer.setVerified(true);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Customer verified successfully");
    }
    
    //Delete the customer with ID
    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<String> deleteCustomerByAdmin(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer and associated auth user deleted successfully by admin.");
    }
    
    //Delete the employee with ID
    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee and associated AuthUser deleted successfully.");
    }

    
}
