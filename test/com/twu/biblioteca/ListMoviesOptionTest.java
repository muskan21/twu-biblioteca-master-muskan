package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListMoviesOptionTest {

    @Test
    public void shouldReturnTheListOfMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Muskan", 1234, "Director", "10"));
        movies.add(new Movie("Muskan Dhanda", 123, "Director Same", "unrated"));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ListMoviesOption listMovies = new ListMoviesOption(movieLibrary);

        String movieString = listMovies.execute();

        String testString = String.format("%-30s %-30s %-30s %-30s\n\n%-30s %-30d %-30s %-30s\n%-30s %-30d %-30s %-30s\n", "Movie Name", "Year", "Director", "Rating", "Muskan", 1234, "Director", "10", "Muskan Dhanda", 123, "Director Same", "unrated");
        assertEquals(testString, movieString);
    }

    @Test
    public void shouldReturnTheAvailableListOfMoviesInTheLibrary() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Muskan D", 1234, "Director", "10"));
        movies.add(new Movie("Muskan Dhanda", 123, "Director Same", "unrated"));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ListMoviesOption listMovies = new ListMoviesOption(movieLibrary);

        String bookString = listMovies.execute();

        String testString = String.format("%-30s %-30s %-30s %-30s\n\n%-30s %-30d %-30s %-30s\n%-30s %-30d %-30s %-30s\n", "Movie Name", "Year", "Director", "Rating", "Muskan D", 1234, "Director", "10", "Muskan Dhanda", 123, "Director Same", "unrated");
        assertEquals(testString, bookString);
    }
}
