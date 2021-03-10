package com.movieranking.backend.user.services;

import com.movieranking.backend.user.models.User;

public interface UserService {

    void save(User user);

    User findByLogin(String login);
}
