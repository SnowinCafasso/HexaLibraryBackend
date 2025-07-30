package com.example.maverickBank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.maverickBank.dto.EmployeeRegistrationDto;
import com.example.maverickBank.entity.Employee;
import com.example.maverickBank.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    // Updated registration endpoint using DTO
    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeRegistrationDto dto) {
        return empService.registerEmployee(dto);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = empService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        Employee employeeById = empService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int empId, @RequestBody Employee emp) {
        Employee updatedEmployee = empService.updateEmployeeById(empId, emp);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @PatchMapping("/{empId}")
    public ResponseEntity<Employee> patchEmployeeById(@PathVariable int empId, @RequestBody Employee emp) {
        Employee patchedEmployee = empService.patchEmployeeById(empId, emp);
        return new ResponseEntity<>(patchedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) {
        empService.deleteEmployeeById(empId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
