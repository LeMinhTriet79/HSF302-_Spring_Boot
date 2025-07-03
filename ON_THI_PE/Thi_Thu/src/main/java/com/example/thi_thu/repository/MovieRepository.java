package com.example.thi_thu.repository;

import com.example.thi_thu.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("SELECT m from Movie m where m.movieName LIKE %:keyword% OR m.director.directorName LIKE %:keyword%")
    List<Movie> searchMovies(@Param("keyword") String keyword);
}
