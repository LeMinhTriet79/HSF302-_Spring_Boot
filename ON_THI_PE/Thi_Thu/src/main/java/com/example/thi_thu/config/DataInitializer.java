package com.example.thi_thu.config;

import com.example.thi_thu.entity.Account;
import com.example.thi_thu.entity.Director;
import com.example.thi_thu.entity.Movie;
import com.example.thi_thu.repository.AccountRepository;
import com.example.thi_thu.repository.DirectorRepository;
import com.example.thi_thu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private DirectorRepository directorRepo;
    @Autowired
    private MovieRepository movieRepo;

    @Override
    public void run(String... args) {
        // Account
        Account admin = new Account("admin@gmail.com", "123456", 1, true);
        Account manager = new Account("manager@gmail.com", "123456", 3, true);
        Account customer = new Account("customer@gmail.com", "123456", 4, true);
        accountRepo.saveAll(Arrays.asList(admin, manager, customer));

        // Director
        Director d1 = new Director("Christopher Nolan");
        Director d2 = new Director("Quentin Tarantino");
        directorRepo.saveAll(Arrays.asList(d1, d2));

        // Movie
        Movie m1 = new Movie("Inception", 120, "Leonardo DiCaprio", Movie.Status.ACTIVE, d1);
        Movie m2 = new Movie("Django Unchained", 100, "Jamie Foxx", Movie.Status.COMING, d2);
        movieRepo.saveAll(Arrays.asList(m1, m2));
    }
}