package com.twu.biblioteca;

public class Parser {

    private BookLibrary books;

    public Parser(BookLibrary books) {
        this.books = books;
    }

    public MenuOptions parse(String input) {
        return new ListBooksOption(books);
    }
}
