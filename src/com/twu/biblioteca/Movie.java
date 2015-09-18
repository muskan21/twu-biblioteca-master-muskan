//Has all the details about a movie and is responsible for providing the formatted printable details of the movie.
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
        return String.format("%-30s %-30d %-30s %-30s\n", name, year, director, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return name.toLowerCase().equals(movie.name.toLowerCase());

    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
