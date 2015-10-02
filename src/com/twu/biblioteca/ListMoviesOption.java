package com.twu.biblioteca;

public class ListMoviesOption implements MenuOptions {
    private MovieLibrary movies;

    public ListMoviesOption(MovieLibrary movies) {
        this.movies = movies;
    }

    public String execute() {
        String movieList = movies.formattedListOfAvailableMovies();
        return movieList;
    }
}
