package com.movieranking.backend.genre.services;

import com.movieranking.backend.genre.models.Genre;
import com.movieranking.backend.genre.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Set<Genre> findAll() {
        return new HashSet<Genre>(genreRepository.findAll());
    }
}
