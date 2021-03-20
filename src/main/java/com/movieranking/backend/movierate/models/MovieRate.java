package com.movieranking.backend.movierate.models;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.user.models.User;

import javax.persistence.*;

@Entity
public class MovieRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_id")
    User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
