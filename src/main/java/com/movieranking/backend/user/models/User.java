package com.movieranking.backend.user.models;

import com.movieranking.backend.gender.models.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    @Size(min = 5, max = 20)
    @NotBlank(message = "Login is mandatory!")
    private String login;

    @Column(unique = true, nullable = false, length = 20)
    @Size(min = 5, max = 20)
    @NotBlank(message = "Email is mandatory!")
    private String email;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(length = 100)
    @Size(min = 5, max = 100)
    private String specialNotes;
}
