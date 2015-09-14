package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldReturnTheFormattedMovieDetails() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");

        String movieDetails = movie.formattedMovieDetails();

        String testString = String.format("%-30s %-30d %-30s %-30s\n", "Muskan", 1234, "Woohhoo", "10");
        assertEquals(testString, movieDetails);
    }
}
