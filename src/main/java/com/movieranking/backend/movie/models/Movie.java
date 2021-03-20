package com.movieranking.backend.movie.models;

import com.movieranking.backend.country.models.Country;
import com.movieranking.backend.genre.models.Genre;
import com.movieranking.backend.movieauthor.models.MovieAuthor;
import com.movieranking.backend.movierate.models.MovieRate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

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

    @ManyToMany
    private Set<Country> country;

    @ManyToMany
    private Set<Genre> genre;

    @OneToMany(mappedBy = "user")
    private Set<MovieAuthor> movieAuthor;

    @OneToMany(mappedBy = "user")
    private Set<MovieRate> movieRates;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
