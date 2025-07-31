package com.example.maverickBank.dto;

import java.time.LocalDate;

public class CustomerRegistrationDto {
    // Customer fields
    private String customerType;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String gender;
    private LocalDate dob; 
    // AuthUser fields
    private String password;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerRegistrationDto(String customerType, String customerName, String customerEmail,
			String customerPhoneNumber, String gender, LocalDate dob, String password) {
		super();
		this.customerType = customerType;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
	}

    public CustomerRegistrationDto() {
		// TODO Auto-generated constructor stub
	}
    
}
