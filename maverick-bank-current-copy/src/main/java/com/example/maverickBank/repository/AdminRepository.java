package com.example.maverickBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}