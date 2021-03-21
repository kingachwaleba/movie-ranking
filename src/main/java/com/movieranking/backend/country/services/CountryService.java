package com.movieranking.backend.country.services;

import com.movieranking.backend.country.models.Country;

import java.util.Set;

public interface CountryService {

    Set<Country> findAll();
}
