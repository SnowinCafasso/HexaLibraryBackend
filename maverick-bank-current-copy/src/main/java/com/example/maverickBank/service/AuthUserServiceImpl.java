package com.example.maverickBank.service;

import com.example.maverickBank.dto.AuthRequest;
import com.example.maverickBank.entity.AuthUser;
import com.example.maverickBank.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository authRepo;

    @Override
    public ResponseEntity<?> registerUser(AuthUser authUser) {
        Map<String, String> response = new HashMap<>();

        // Only customers can register themselves
        if (!"customer".equalsIgnoreCase(authUser.getUserType())) {
            response.put("error", "Only customers can self-register. Employees must be added by admin.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        // Check if email already exists
        Optional<AuthUser> existingByEmail = authRepo.findByEmail(authUser.getEmail());
        if (existingByEmail.isPresent()) {
            response.put("error", "Email already registered.");
            return ResponseEntity.badRequest().body(response);
        }

        // Check if userId is already registered
        Optional<AuthUser> existingByUserId = authRepo.findByUserId(authUser.getUserId());
        if (existingByUserId.isPresent()) {
            response.put("error", "This customer is already registered.");
            return ResponseEntity.badRequest().body(response);
        }

        AuthUser saved = authRepo.save(authUser);
        response.put("message", "Registration successful");
        return ResponseEntity.ok(response);
    }



    @Override
    public ResponseEntity<?> loginUser(AuthRequest authRequest) {
        Optional<AuthUser> user = authRepo.findByEmailAndPassword(
                authRequest.getEmail(), authRequest.getPassword());

        Map<String, String> response = new HashMap<>();

        if (user.isPresent()) {
            response.put("message", "Login successful");
            response.put("userType", user.get().getUserType());
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
