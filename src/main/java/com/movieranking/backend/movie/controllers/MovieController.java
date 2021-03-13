package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    @GetMapping("/index")
//    public String showMovies(Model model) {
//        model.addAttribute("movies", movieRepository.findAll());
//        return "main-layout";
//    }
}
