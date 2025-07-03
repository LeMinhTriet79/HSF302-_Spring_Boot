package com.example.thi_thu.service;

import com.example.thi_thu.entity.Movie;
import com.example.thi_thu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    public List<Movie> search(String keyword) {
        return movieRepo.searchMovies(keyword);
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepo.findById(id);
    }

    public void delete(Long id) {
        movieRepo.deleteById(id);
    }
}