package com.example.maverickBank.service;

import org.springframework.stereotype.Service;

import com.example.maverickBank.entity.Branch;
import com.example.maverickBank.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	private BranchRepository bankRepo;

	public BranchServiceImpl(BranchRepository branchRepository) {
		super();
		this.bankRepo = branchRepository;
	}

	@Override
	public Branch createBankBranch(Branch branch) {
		return bankRepo.save(branch);
	}
	
}