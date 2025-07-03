package com.example.thi_thu.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {
    public enum Status { ACTIVE, INACTIVE, COMING }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String movieName;

    private int duration;

    private String actor;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Movie() {}

    public Movie(String movieName, int duration, String actor, Status status, Director director) {
        this.movieName = movieName;
        this.duration = duration;
        this.actor = actor;
        this.status = status;
        this.director = director;
    }

    // Getters & Setters

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
