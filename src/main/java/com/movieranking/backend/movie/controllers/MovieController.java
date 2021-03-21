package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.movie.repositories.MovieRepository;
import com.movieranking.backend.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/add-movie")
    public String addMovie(Model model) {
        model.addAttribute("movieForm", new Movie());

        return "views/add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovie(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult) {
        movieService.save(movieForm);

        return "redirect:/index";
    }
}
