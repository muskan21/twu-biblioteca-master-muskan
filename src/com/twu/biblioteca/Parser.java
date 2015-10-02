package com.twu.biblioteca;

public class Parser {

    private BookLibrary books;
    private MovieLibrary movies;
    private OutputConsole outputConsole;
    private InputConsole inputConsole;

    public Parser(BookLibrary books, MovieLibrary movies, OutputConsole outputConsole, InputConsole inputConsole) {
        this.books = books;
        this.movies = movies;
        this.outputConsole = outputConsole;
        this.inputConsole = inputConsole;
    }

    public MenuOptions parse(String input) {
        if("1".equals(input))
            return new ListBooksOption(books);
        if ("2".equals(input))
            return new ListMoviesOption(movies);
        if ("3".equals(input))
            return new CheckOutMovieOption(outputConsole, inputConsole, movies);
        return new InvalidOption("Select A Valid Option.");
    }
}
