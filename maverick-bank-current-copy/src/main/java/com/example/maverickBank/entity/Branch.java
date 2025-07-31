package com.example.maverickBank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bank_Branches")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchCode;
	private String branchContact;
	private String location;
	
	// Default Constructor
	public Branch() {
		super();
	}
	
	// Parameterized Constructor
	public Branch(int branchId, String branchName, String branchCode, String branchContact, String location) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.branchContact = branchContact;
		this.location = location;
	}
	
	// Getters & Setters for the above fields
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getbranchContact() {
		return branchContact;
	}
	public void setbranchContact(String branchContact) {
		this.branchContact = branchContact;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}