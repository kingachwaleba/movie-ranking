package com.movieranking.backend.movieauthor.repositories;

import com.movieranking.backend.movieauthor.models.MovieAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieAuthorRepository extends JpaRepository<MovieAuthor, Long> {
}
