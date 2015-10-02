package com.twu.biblioteca;

public class Parser {

    private BookLibrary books;
    private MovieLibrary movies;

    public Parser(BookLibrary books, MovieLibrary movies) {
        this.books = books;
        this.movies = movies;
    }

    public MenuOptions parse(String input) {
        if("1".equals(input))
            return new ListBooksOption(books);
        if ("2".equals(input))
            return new ListMoviesOption(movies);
        return new InvalidOption("Select A Valid Option.");
    }
}
