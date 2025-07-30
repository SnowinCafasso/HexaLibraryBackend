package com.example.maverickBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maverickBank.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>{
	//Find user by Email
	Optional<AuthUser> findByEmail(String email);
	
	//Find user by Email and Password 
	Optional<AuthUser> findByEmailAndPassword(String email, String password);
	
	//Find user by userID
	Optional<AuthUser> findByUserId(Long userId);

}
	