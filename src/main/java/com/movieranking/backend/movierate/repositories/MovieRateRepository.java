package com.movieranking.backend.movierate.repositories;

import com.movieranking.backend.movierate.models.MovieRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRateRepository extends JpaRepository<MovieRate, Long> {
}
