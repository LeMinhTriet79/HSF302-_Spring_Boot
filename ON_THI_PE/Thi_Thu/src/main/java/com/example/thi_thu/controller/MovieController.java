package com.example.thi_thu.controller;



import com.example.thi_thu.entity.Account;
import com.example.thi_thu.entity.Movie;
import com.example.thi_thu.service.DirectorService;
import com.example.thi_thu.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private DirectorService directorService;

    // List & Search
    @GetMapping
    public String listMovies(Model model, @RequestParam(required = false) String keyword, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null) return "redirect:/login";
        List<Movie> movies = (keyword == null || keyword.isEmpty())
                ? movieService.findAll()
                : movieService.search(keyword);
        model.addAttribute("movies", movies);
        model.addAttribute("role", acc.getRole());
        model.addAttribute("keyword", keyword);
        return "movies";
    }

    // Thêm mới (GET)
    @GetMapping("/add")
    public String addForm(Model model, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null || acc.getRole() != 1) return "redirect:/movies";
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorService.findAll());
        model.addAttribute("statuses", Movie.Status.values());
        return "movie-form";
    }

    // Thêm mới (POST)
    @PostMapping("/add")
    public String saveMovie(@ModelAttribute("movie") Movie movie, Model model, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null || acc.getRole() != 1) return "redirect:/movies";
        // Bạn có thể thêm validate ở đây nếu muốn
        movieService.save(movie);
        return "redirect:/movies";
    }

    // Chỉnh sửa (GET)
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null || acc.getRole() != 1) return "redirect:/movies";
        Movie movie = movieService.findById(id).orElse(null);
        if (movie == null) return "redirect:/movies";
        model.addAttribute("movie", movie);
        model.addAttribute("directors", directorService.findAll());
        model.addAttribute("statuses", Movie.Status.values());
        return "movie-form";
    }

    // Chỉnh sửa (POST)
    @PostMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null || acc.getRole() != 1) return "redirect:/movies";
        movie.setMovieId(id);
        movieService.save(movie);
        return "redirect:/movies";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        Account acc = (Account) session.getAttribute("user");
        if (acc == null || acc.getRole() != 1) return "redirect:/movies";
        movieService.delete(id);
        return "redirect:/movies";
    }
}


    // Validate
//    private String validateMovie(Movie movie) {
//        if (movie.getMovieName() == null || movie.getMovieName().isEmpty())
//            return "Movie name is required";
//        if (movie.getMovieName().length() >= 20)
//            return "Movie name must be less than 20 characters";
//        if (!movie.getMovieName().matches("([A-Z][a-z]+)(\\s[A-Z][a-z]+)*"))
//            return "Each word must start with a capital letter, no numbers or special chars";
//        if (movie.getDuration() < 75 || movie.getDuration() > 120)
//            return "Duration must be between 75 and 120";
//        if (movie.getActor() == null || movie.getActor().isEmpty())
//            return "Actor is required";
//        if (movie.getStatus() == null)
//            return "Status is required";
//        if (movie.getDirector() == null)
//            return "Director is required";
//        return null;
//    }

