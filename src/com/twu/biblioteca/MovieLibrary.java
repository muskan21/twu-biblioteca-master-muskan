package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    public static final String UNKNOWN_RATING = "unrated";
    public static final String UNKNOWN_DIRECTOR = "";
    public static final int UNKNOWN_YEAR = 0;
    private ArrayList<Movie> movieList;

    public MovieLibrary(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public String formattedListOfAvailableMovies() {
        String moviesList = String.format("%-30s %-30s %-30s %-30s\n\n", "Movie Name", "Year", "Director", "Rating");
        for(Movie movie : movieList) {
            moviesList += movie.formattedMovieDetails();
        }
        return moviesList;
    }

    public void checkOutMovie(String movieName) {
        Movie movie = new Movie(movieName, UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING);
        movieList.remove(movie);
        return;
    }
}
