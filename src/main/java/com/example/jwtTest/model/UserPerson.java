package com.example.jwtTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;


@Entity
public class UserPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;

    private int age;

    private String password;

    @Column(unique = true)
    private String email;

    public UserPerson() {
    }

    public UserPerson(Long id, String username, int age, String password, String email) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
