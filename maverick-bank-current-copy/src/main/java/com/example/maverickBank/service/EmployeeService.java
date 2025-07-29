package com.example.maverickBank.service;

import java.util.List;

import com.example.maverickBank.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int empId);
	void deleteEmployeeById(int empId);
	Employee updateEmployeeById(int empId, Employee employee);
	Employee patchEmployeeById(int empId, Employee employee);
}