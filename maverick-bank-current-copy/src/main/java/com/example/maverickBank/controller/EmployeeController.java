package com.example.maverickBank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maverickBank.entity.Employee;
import com.example.maverickBank.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	private EmployeeService empService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.empService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee newEmployee = empService.createEmployee(emp);
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED); 
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee employeeById = empService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int empId, @RequestBody Employee emp) {
		Employee updatedEmployee = empService.updateEmployeeById(empId, emp);
		
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
	
	@PatchMapping("/{empId}")
	public ResponseEntity<Employee> patchEmployeeById(@PathVariable int empId, @RequestBody Employee emp) {
		Employee patchedEmployee = empService.patchEmployeeById(empId, emp);
		return new ResponseEntity<Employee>(patchedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
}