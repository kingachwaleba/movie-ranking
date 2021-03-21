package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.country.models.Country;
import com.movieranking.backend.country.services.CountryService;
import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class MovieController {

    private final MovieService movieService;

    private final CountryService countryService;

    @Autowired
    public MovieController(MovieService movieService, CountryService countryService) {
        this.movieService = movieService;
        this.countryService = countryService;
    }

    @GetMapping("/add-movie")
    public String addMovie(Model model) {
        model.addAttribute("movieForm", new Movie());

        Set<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);

        return "views/add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovie(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult) {
        movieService.save(movieForm);

        return "redirect:/index";
    }
}
