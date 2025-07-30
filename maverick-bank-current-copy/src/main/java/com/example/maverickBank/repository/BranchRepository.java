package com.example.maverickBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}