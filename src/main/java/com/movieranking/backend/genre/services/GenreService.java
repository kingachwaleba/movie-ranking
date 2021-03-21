package com.movieranking.backend.genre.services;

import com.movieranking.backend.genre.models.Genre;

import java.util.Set;

public interface GenreService {

    Set<Genre> findAll();

}
