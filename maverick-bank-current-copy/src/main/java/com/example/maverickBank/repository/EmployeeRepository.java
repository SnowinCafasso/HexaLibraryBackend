package com.example.maverickBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}