package com.movieranking.backend.movieauthor.models;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.user.models.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(length = 1000)
    @Size(min = 5, max = 1000)
    private String description;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
