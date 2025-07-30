package com.example.maverickBank.service;

import java.util.List;

import com.example.maverickBank.entity.Transaction;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByAccountId(Long accountId);
    Transaction createTransaction(Transaction transaction);
}
