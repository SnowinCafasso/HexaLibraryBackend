package com.example.maverickBank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maverickBank.entity.Branch;
import com.example.maverickBank.service.BranchService;

@RestController
@RequestMapping("api/branch")
public class BranchController {
	private BranchService branchService;

	public BranchController(BranchService branchService) {
		super();
		this.branchService = branchService;
	}
	
	@PostMapping
	public ResponseEntity<Branch> createBankBranch(@RequestBody Branch branch) {
		Branch savedBranch = branchService.createBankBranch(branch);
		return new ResponseEntity<Branch>(savedBranch, HttpStatus.CREATED);
	}
}