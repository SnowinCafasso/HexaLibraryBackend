package com.example.maverickBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maverickBank.entity.Account;
import com.example.maverickBank.entity.Customer;
import com.example.maverickBank.repository.AccountRepository;
import com.example.maverickBank.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	 @Autowired
	 private AccountRepository accountRepository;

	 @Autowired
	 private CustomerRepository customerRepository;

 	@Override
	 public Account createAccount(Account account) {
	     Long customerId = account.getCustomer().getCustomerId();
	     Customer customer = customerRepository.findById(customerId)
	         .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
	     account.setCustomer(customer);
	     return accountRepository.save(account);
	 }

 @Override
	 public Account getAccountById(Long id) {
	     return accountRepository.findById(id)	
	         .orElseThrow(() -> new RuntimeException("Account not found with ID: " + id));
	 }
}
