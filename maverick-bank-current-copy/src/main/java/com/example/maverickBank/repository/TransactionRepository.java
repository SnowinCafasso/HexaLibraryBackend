package com.example.maverickBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	// Find all transactions for a specific account
    List<Transaction> findByAccountId(Long accountId);

    // Find all transactions by status
    List<Transaction> findByTransactionStatus(Transaction.TransactionStatus status);
}
