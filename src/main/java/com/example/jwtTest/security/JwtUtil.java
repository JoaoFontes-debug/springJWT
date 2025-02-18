package com.example.jwtTest.security;

import java.security.Signature;

public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expirationTime;
    
    //metodo para gerar token
    public String generatedToken(String username){
        return jwsts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration((new Date(System.currentTimeMillis() + expirationTime)))
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();

    }

    public boolean isTokenValid(String token){
        try {
            jwts.parser().setSigningKey(secret).parseClaimsJws((token));
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
