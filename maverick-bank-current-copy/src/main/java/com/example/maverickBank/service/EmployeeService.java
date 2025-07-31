package com.example.maverickBank.service;

import com.example.maverickBank.dto.EmployeeRegistrationDto;
import com.example.maverickBank.entity.Employee;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	//Register employee and Auth
    ResponseEntity<?> registerEmployee(EmployeeRegistrationDto employeeDto);
    //Get all Employees
    List<Employee> getAllEmployees();
    //Get Employee by ID
    Employee getEmployeeById(int empId);
    //Delete employee by ID
    void deleteEmployeeById(int empId);
    //Update employee by ID (PUT)
    Employee updateEmployeeById(int empId, Employee employee);
    //Update employee by ID (PATCH)
    Employee patchEmployeeById(int empId, Employee employee);
    
}
