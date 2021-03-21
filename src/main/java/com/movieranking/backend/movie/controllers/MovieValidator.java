package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.movie.services.MovieService;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {

    private final MovieService movieService;

    public MovieValidator(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (movie.getName().length() > 51) {
            errors.rejectValue("name", "Size.movieForm.name");
        }
        if (movieService.findByName(movie.getName()) != null) {
            errors.rejectValue("name", "Duplicate.movieForm.name");
        }

        if (movie.getDescription().length() != 0 && movie.getDescription().length() > 1000) {
            errors.rejectValue("description", "Size.movieForm.description");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "NotEmpty");
        if (movie.getYear() < 1850 || movie.getYear() > 2100) {
            errors.rejectValue("year", "Size.movieForm.year");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "NotEmpty");
    }
}
