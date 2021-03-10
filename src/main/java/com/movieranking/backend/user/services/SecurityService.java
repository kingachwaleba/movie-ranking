package com.movieranking.backend.user.services;

public interface SecurityService {

    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
