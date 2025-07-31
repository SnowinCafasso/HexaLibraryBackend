package com.example.maverickBank.service;

import com.example.maverickBank.dto.AuthRequest;
import com.example.maverickBank.entity.AuthUser;
import org.springframework.http.ResponseEntity;

public interface AuthUserService {
    ResponseEntity<?> registerUser(AuthUser auth);
    ResponseEntity<?> loginUser(AuthRequest authRequest);
}
