package com.twu.biblioteca;

public class Parser {

    private BookLibrary books;

    public Parser(BookLibrary books) {
        this.books = books;
    }

    public MenuOptions parse(String input) {
        if("2".equals(input))
            return new InvalidOption("Select A Valid Option.");
        return new ListBooksOption(books);
    }
}
