package com.example.maverickBank.service;

import com.example.maverickBank.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(Long id);
}
