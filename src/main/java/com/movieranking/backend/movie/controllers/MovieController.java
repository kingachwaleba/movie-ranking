package com.movieranking.backend.movie.controllers;

import com.movieranking.backend.country.models.Country;
import com.movieranking.backend.country.services.CountryService;
import com.movieranking.backend.genre.models.Genre;
import com.movieranking.backend.genre.services.GenreService;
import com.movieranking.backend.movie.models.Movie;
import com.movieranking.backend.movie.services.MovieService;
import com.movieranking.backend.movieauthor.models.MovieAuthor;
import com.movieranking.backend.user.models.User;
import com.movieranking.backend.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Set;

@Controller
public class MovieController {

    private final MovieService movieService;

    private final CountryService countryService;

    private final GenreService genreService;

    private final MovieValidator movieValidator;

    private final UserRepository userRepository;

    @Autowired
    public MovieController(MovieService movieService, CountryService countryService, GenreService genreService, MovieValidator movieValidator, UserRepository userRepository) {
        this.movieService = movieService;
        this.countryService = countryService;
        this.genreService = genreService;
        this.movieValidator = movieValidator;
        this.userRepository = userRepository;
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

    @Transactional
    @PostMapping("/add-movie")
    public String addMovie(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult) {
        movieValidator.validate(movieForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "views/add-movie";
        }

        MovieAuthor movieAuthor = new MovieAuthor();

        // Get current date and set it
        Date date = new Date();
        movieAuthor.setEditedAt(date);

        // Get current logged in user and set it
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserLogin = authentication.getName();
        User user = userRepository.findByLogin(currentUserLogin);
        movieAuthor.setUser(user);

        movieForm.addMovieAuthor(movieAuthor);

        movieService.save(movieForm);

        return "redirect:/index";
    }
}
