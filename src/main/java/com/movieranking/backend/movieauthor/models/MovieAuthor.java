package com.movieranking.backend.movieauthor.models;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.user.models.User;

import javax.persistence.*;

@Entity
public class MovieAuthor {

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
}
