package com.movieranking.backend.gender.models;

import com.movieranking.backend.user.models.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<User> users;
}
