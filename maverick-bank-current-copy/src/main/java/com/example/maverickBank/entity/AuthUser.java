package com.example.maverickBank.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
import java.util.Collection;
import java.util.Collections;
 
@Entity
@Table(name = "authentication")
public class AuthUser implements UserDetails {
	
	private static final long serialVersionUID = 1L;
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String email;
 
    @Column(nullable = false)
    private String password;
 
    @Column(nullable = false)
    private String userType;
 
    @Column(nullable = false)
    private Long userId;
 
    // Constructors
    public AuthUser() {
    }
 
    public AuthUser(Long id, String email, String password, String userType, Long userId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
    }
 
    // Getters and Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUserType() {
        return userType;
    }
 
    public void setUserType(String userType) {
        this.userType = userType;
    }
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    // --- UserDetails implementation ---
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // No roles/authorities for now
        return Collections.emptyList();
    }
 
    @Override
    public String getUsername() {
        return email;  // we use email as the username
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    
}