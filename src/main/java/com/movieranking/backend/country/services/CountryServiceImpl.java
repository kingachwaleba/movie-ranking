package com.movieranking.backend.country.services;

import com.movieranking.backend.country.models.Country;
import com.movieranking.backend.country.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Set<Country> findAll() {
        return new HashSet<Country>(countryRepository.findAll());
    }
}
