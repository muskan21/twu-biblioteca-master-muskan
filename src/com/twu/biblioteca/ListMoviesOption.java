package com.twu.biblioteca;

public class ListMoviesOption implements MenuOptions {
    private MovieLibrary movies;

    public ListMoviesOption(MovieLibrary movies) {
        this.movies = movies;
    }

    public String execute() {
        String movieList = String.format("%-30s %-30s %-30s %-30s\n\n%-30s %-30d %-30s %-30s\n%-30s %-30d %-30s %-30s\n", "Movie Name", "Year", "Director", "Rating", "Muskan", 1234, "Director", "10", "Muskan Dhanda", 123, "Director Same", "unrated");
        return movieList;
    }
}
