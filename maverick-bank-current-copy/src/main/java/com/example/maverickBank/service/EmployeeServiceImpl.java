package com.example.maverickBank.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
 
import com.example.maverickBank.dto.EmployeeRegistrationDto;
import com.example.maverickBank.entity.AuthUser;
import com.example.maverickBank.entity.Branch;
import com.example.maverickBank.entity.Employee;
import com.example.maverickBank.repository.AuthUserRepository;
import com.example.maverickBank.repository.BranchRepository;
import com.example.maverickBank.repository.EmployeeRepository;
 
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
    private final EmployeeRepository empRepo;
    private final BranchRepository branchRepo;
    private final AuthUserRepository authUserRepo;
 
    public EmployeeServiceImpl(EmployeeRepository empRepo,
                               BranchRepository branchRepo,
                               AuthUserRepository authUserRepo) {
        this.empRepo = empRepo;
        this.branchRepo = branchRepo;
        this.authUserRepo = authUserRepo;
    }
 
    @Override
    public ResponseEntity<?> registerEmployee(EmployeeRegistrationDto dto) {
        if (authUserRepo.findByEmail(dto.getEmployeeEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use.");
        }
 
        Branch branch = branchRepo.findById(dto.getBranchId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Branch not found"));
 
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmployeeRole(dto.getEmployeeRole());
        employee.setEmployeeEmail(dto.getEmployeeEmail());
        employee.setEmployeePhone(dto.getEmployeePhone());
        employee.setGender(dto.getGender());
        employee.setDob(dto.getDob());
        employee.setBranch(branch);
 
        Employee savedEmployee = empRepo.save(employee);
 
        AuthUser authUser = new AuthUser();
        authUser.setEmail(dto.getEmployeeEmail());
        authUser.setPassword(dto.getPassword()); // Will encrypt later
        authUser.setUserType("employee");
        authUser.setUserId((long) savedEmployee.getEmployeeId());
 
        authUserRepo.save(authUser);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
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