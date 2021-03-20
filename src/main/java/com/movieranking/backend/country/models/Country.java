package com.movieranking.backend.country.models;

import com.movieranking.backend.movie.models.Movie;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "country")
    private List<Movie> movie;

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

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
