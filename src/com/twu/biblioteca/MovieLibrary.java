/*Has the list of all movies available in the system and is responsible for checking out a movie from the library
and providing a printable formatted detail of the movie library.
 */
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

    public String checkOutMovie(String movieName) {
        Movie movie = new Movie(movieName, UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING);
        if(movieList.contains(movie)) {
            movieList.remove(movie);
            return "Successful CheckOut.";
        }
        return "Unsuccessful CheckOut.";
    }
}
