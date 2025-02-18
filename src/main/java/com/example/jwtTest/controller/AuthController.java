package com.example.jwtTest.controller;

import com.example.jwtTest.model.UserPerson;
import com.example.jwtTest.repository.UserPersonRepository;
import com.example.jwtTest.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserPersonRepository userPersonRepository;

    private final JwtUtil jwtUtil;

    public AuthController(UserPersonRepository userPersonRepository, JwtUtil jwtUtil) {
        this.userPersonRepository = userPersonRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserPerson userPerson){
        Optional<UserPerson> foundUser = userPersonRepository.findByUserName(userPerson.getUsername());

        if(foundUser.isPresent() && foundUser.get().getPassword().equals(userPerson.getPassword())){
            String token = jwtUtil.generatedToken(userPerson.getUsername());
            return ResponseEntity.ok().body("\"accessToken" + token);
        }
        return ResponseEntity.status(401).body("credenciais invalidas");
    }
}
