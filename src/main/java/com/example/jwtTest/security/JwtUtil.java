package com.example.jwtTest.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expirationTime;
    
    //metodo para gerar token
    public String generatedToken(String username){
        return Jwts.builder()
        .setSubject(username)//conteudo
        .setIssuedAt(new Date()) //momento que é gerado
        .setExpiration((new Date(System.currentTimeMillis() + expirationTime))) //expiração
        .signWith(SignatureAlgorithm.HS256, secret) //
        .compact();

    }

    public String getUserNameFromtoken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()//payload
                .getSubject();//conteudo
    }

    public boolean isTokenValid(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws((token));
            return true;
        } catch (Exception error) {
           return  false;
        }
    }

}
