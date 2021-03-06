package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieLibraryTest {

    @Test
    public void shouldReturnTheListOfMoviesInAStringFormat() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        
        String movieListDetails = movieLibrary.formattedListOfAvailableMovies();

        String testString = String.format("%-30s %-30s %-30s %-30s\n\n%-30s %-30d %-30s %-30s\n", "Movie Name", "Year", "Director", "Rating", "Muskan", 1234, "Woohhoo", "10");

        assertEquals(testString, movieListDetails);
    }

    @Test
    public void shouldCheckoutTheMovieAvailableInTheLibrary() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        String beforeCheckOutList = movieLibrary.formattedListOfAvailableMovies();

        movieLibrary.checkOutMovie("Muskan");
        String afterCheckOutList = movieLibrary.formattedListOfAvailableMovies();

        assertNotEquals(beforeCheckOutList, afterCheckOutList);
    }

    @Test
    public void shouldNotCheckOutTheMovieNotAvailableInTheLibrary() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        String beforeCheckOutList = movieLibrary.formattedListOfAvailableMovies();

        movieLibrary.checkOutMovie("MuskanD");
        String afterCheckOutList = movieLibrary.formattedListOfAvailableMovies();

        assertEquals(beforeCheckOutList, afterCheckOutList);
    }

    @Test
    public void shouldPrintAppropriateMessageWhenSucessfulMovieCheckout() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        String checkOutMessage = movieLibrary.checkOutMovie("Muskan");

        assertEquals("Successful CheckOut.", checkOutMessage);
    }

    @Test
    public void shouldPrintAppropriateMessageWhenUnsucessfulMovieCheckout() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        String checkOutMessage = movieLibrary.checkOutMovie("MuskanD");

        assertEquals("Unsuccessful CheckOut.", checkOutMessage);
    }
}
