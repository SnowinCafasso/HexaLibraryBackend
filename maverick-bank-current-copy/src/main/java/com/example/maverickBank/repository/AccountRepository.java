package com.example.maverickBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
