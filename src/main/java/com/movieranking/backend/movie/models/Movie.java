package com.movieranking.backend.movie.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 50)
    @Size(min = 1, max = 50)
    @NotBlank(message = "Name is mandatory!")
    private String name;

    @Column(length = 1000)
    @Size(min = 50, max = 1000)
    private String description;

    @Column(nullable = false, length = 4)
    @Size(min = 4, max = 4)
    @NotBlank(message = "Year is mandatory!")
    private String year;
}
