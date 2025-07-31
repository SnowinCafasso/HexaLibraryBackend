package com.example.maverickBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
