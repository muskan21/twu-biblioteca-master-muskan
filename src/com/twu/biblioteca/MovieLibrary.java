package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
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
}
