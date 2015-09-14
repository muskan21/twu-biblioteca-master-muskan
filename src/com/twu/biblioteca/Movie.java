package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private String rating;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String formattedMovieDetails() {
        return String.format("%-30s %-30d %-30s %-30s", name, year, director, rating);
    }
}
