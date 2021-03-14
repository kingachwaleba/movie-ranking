package com.movieranking.backend.user.services;

public interface SecurityService {

    boolean isAuthenticated();

    void autoLogin(String login, String password);
}
