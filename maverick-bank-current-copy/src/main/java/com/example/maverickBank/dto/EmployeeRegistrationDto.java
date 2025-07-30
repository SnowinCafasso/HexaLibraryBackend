package com.example.maverickBank.dto;

import java.sql.Date;

public class EmployeeRegistrationDto {
    private String employeeRole;
    private String employeeName;
    private String employeeEmail;
    private String employeePhone;
    private String gender;
    private Date dob;
    private int branchId;      
    private String password;
    
    //Getters and Setters
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeRegistrationDto(String employeeRole, String employeeName, String employeeEmail, String employeePhone,
			String gender, Date dob, int branchId, String password) {
		super();
		this.employeeRole = employeeRole;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
		this.gender = gender;
		this.dob = dob;
		this.branchId = branchId;
		this.password = password;
	}  
	
	public EmployeeRegistrationDto() {
		// TODO Auto-generated constructor stub
	}
}
