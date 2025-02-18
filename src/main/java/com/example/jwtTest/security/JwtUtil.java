package com.example.jwtTest.security;

public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expirationTime;
    
    public String generatedToken(String username){
        return jwsts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())

    }

}
