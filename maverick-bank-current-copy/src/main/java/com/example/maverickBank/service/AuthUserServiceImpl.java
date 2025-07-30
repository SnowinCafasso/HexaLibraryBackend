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
    public ResponseEntity<?> registerUser(AuthUser auth) {
        Optional<AuthUser> existing = authRepo.findByEmail(auth.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        return ResponseEntity.ok(authRepo.save(auth));
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