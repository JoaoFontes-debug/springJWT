package com.example.jwtTest.repository;

import java.util.Optional;

import com.example.jwtTest.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonRepository extends JpaRepository<UserPerson, Long> {
    Optional<UserPerson>findByUserName(String username);
    

}
