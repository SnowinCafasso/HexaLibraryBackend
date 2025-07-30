package com.example.maverickBank.controller;

import com.example.maverickBank.dto.AuthRequest;
import com.example.maverickBank.entity.AuthUser;
import com.example.maverickBank.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthUserService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthUser auth) {
        return authService.registerUser(auth);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) {
        return authService.loginUser(authRequest);
    }
}
