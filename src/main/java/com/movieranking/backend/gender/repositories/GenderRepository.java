package com.movieranking.backend.gender.repositories;

import com.movieranking.backend.gender.models.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Long> {
}
