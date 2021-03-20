package com.movieranking.backend.movierate.models;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.user.models.User;

import javax.persistence.*;
import java.util.Date;

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

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
