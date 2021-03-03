package com.movieranking.backend.gender.models;

import javax.persistence.*;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    private String name;
}
