package com.example.maverickBank.service;

import com.example.maverickBank.dto.EmployeeRegistrationDto;
import com.example.maverickBank.entity.Employee;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> registerEmployee(EmployeeRegistrationDto employeeDto);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int empId);
    void deleteEmployeeById(int empId);
    Employee updateEmployeeById(int empId, Employee employee);
    Employee patchEmployeeById(int empId, Employee employee);
}
