package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {

    @Test
    public void shouldReturnTheFormattedMovieDetails() {
        Movie movie = new Movie("Muskan", 1234, "Woohhoo", "10");

        String movieDetails = movie.formattedMovieDetails();

        String testString = String.format("%-30s %-30d %-30s %-30s\n", "Muskan", 1234, "Woohhoo", "10");
        assertEquals(testString, movieDetails);
    }

    @Test
    public void shouldBeEqualWhenComparingAMovieToItself() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "unrated");
        assertEquals(movie, movie);
    }

    @Test
    public void shouldBeEqualWhenComparingAMovieToAnotherMovieWithSameName() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "5");
        Movie movie1 = new Movie("Christmas Carol", 1843, "Charles", "unrated");
        assertEquals(movie, movie1);
    }

    @Test
    public void shouldBeEqualWhenComparingAMovieToAnotherMovieWithSameNameIgnoringTheCase() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "5");
        Movie movie1 = new Movie("christmas carol", 1843, "Charles", "unrated");
        assertEquals(movie, movie1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAMovieToNull() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "6");
        assertNotEquals(movie, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAMovieToNonMovieEntity() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "unrated");
        assertNotEquals(movie, "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingAMovieToAnotherMovieWithDifferentName() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "unrated");
        Movie movie1 = new Movie("Christmas Carol Bleh", 1843, "Charles Dickens", "5");
        assertNotEquals(movie, movie1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingAMovieToItself() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "5");
        assertEquals(movie.hashCode(), movie.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingAMovieToAnotherMovieWithSameName() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "5");
        Movie movie1 = new Movie("Christmas Carol", 1843, "Charles Dickens", "unrated");
        assertEquals(movie.hashCode(), movie1.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeWhenComparingAMovieToAnotherMovieWithSameNameIgnoringTheCase() {
        Movie movie = new Movie("Christmas Carol", 1843, "Charles Dickens", "unrated");
        Movie movie1 = new Movie("christmas carol", 1843, "Charles", "6");
        assertEquals(movie.hashCode(), movie1.hashCode());
    }
}
