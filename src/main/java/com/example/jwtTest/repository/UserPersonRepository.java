package com.example.jwtTest.repository;

import java.util.Optional;

import com.example.jwtTest.model.UserPerson;

public interface UserPersonRepository extends JpaRepository<UserPerson, Long> {
    Optional<UserPerson>findByUserPerson(String username);
    

}
