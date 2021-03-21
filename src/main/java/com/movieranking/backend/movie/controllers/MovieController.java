package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.country.models.Country;
import com.movieranking.backend.country.services.CountryService;
import com.movieranking.backend.genre.models.Genre;
import com.movieranking.backend.genre.services.GenreService;
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

    private final GenreService genreService;

    @Autowired
    public MovieController(MovieService movieService, CountryService countryService, GenreService genreService) {
        this.movieService = movieService;
        this.countryService = countryService;
        this.genreService = genreService;
    }

    @GetMapping("/add-movie")
    public String addMovie(Model model) {
        model.addAttribute("movieForm", new Movie());

        Set<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);

        Set<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);

        return "views/add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovie(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult) {
        movieService.save(movieForm);

        return "redirect:/index";
    }
}
