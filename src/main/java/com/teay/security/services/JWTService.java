package com.teay.security.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(String username);

    String getUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
