package com.example.jwtTest.model;

import javax.annotation.processing.Generated;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class UserPerson {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;
    
    private String username;

    private int age;

    private String password;

    @Column(unique = true)
    private String email;


}
