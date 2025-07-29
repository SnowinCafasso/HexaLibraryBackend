package com.example.maverickBank.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.maverickBank.entity.Branch;
import com.example.maverickBank.entity.Employee;
import com.example.maverickBank.repository.BranchRepository;
import com.example.maverickBank.repository.EmployeeRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository empRepo;
    private final BranchRepository branchRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo, BranchRepository branchRepo) {
        this.empRepo = empRepo;
        this.branchRepo = branchRepo;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        int branchId = employee.getBranch().getBranchId();

        Branch branch = branchRepo.findById(branchId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Bank branch cannot be found"
            ));

        employee.setBranch(branch);
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + empId + " not found"));
    }

    @Override
    public void deleteEmployeeById(int empId) {
        if (!empRepo.existsById(empId)) {
            throw new RuntimeException("Employee with ID " + empId + " not found");
        }
        empRepo.deleteById(empId);
    }

    @Override
    public Employee updateEmployeeById(int empId, Employee employee) {
        Employee existingEmployee = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + empId + " not found"));

        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setEmployeeRole(employee.getEmployeeRole());
        existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        existingEmployee.setEmployeePhone(employee.getEmployeePhone());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setDob(employee.getDob());

        if (employee.getBranch() != null) {
            int branchId = employee.getBranch().getBranchId();
            Branch branch = branchRepo.findById(branchId)
                    .orElseThrow(() -> new RuntimeException("Branch with ID " + branchId + " not found"));

            existingEmployee.setBranch(branch);
        }

        return empRepo.save(existingEmployee);
    }

    @Override
    public Employee patchEmployeeById(int empId, Employee employee) {
        Employee existingEmployee = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + empId + " not found"));

        if (employee.getEmployeeName() != null) {
            existingEmployee.setEmployeeName(employee.getEmployeeName());
        }
        if (employee.getEmployeeRole() != null) {
            existingEmployee.setEmployeeRole(employee.getEmployeeRole());
        }
        if (employee.getEmployeeEmail() != null) {
            existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        }
        if (employee.getEmployeePhone() != null) {
            existingEmployee.setEmployeePhone(employee.getEmployeePhone());
        }
        if (employee.getGender() != null) {
            existingEmployee.setGender(employee.getGender());
        }
        if (employee.getDob() != null) {
            existingEmployee.setDob(employee.getDob());
        }
        if (employee.getBranch() != null) {
            int branchId = employee.getBranch().getBranchId();
            Branch branch = branchRepo.findById(branchId)
                    .orElseThrow(() -> new RuntimeException("Branch with ID " + branchId + " not found"));

            existingEmployee.setBranch(branch);
        }

        return empRepo.save(existingEmployee);
    }
}
