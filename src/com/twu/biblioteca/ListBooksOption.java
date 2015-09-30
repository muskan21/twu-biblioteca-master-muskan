package com.twu.biblioteca;

public class ListBooksOption implements MenuOptions {
    private BookLibrary books;

    public ListBooksOption(BookLibrary books) {
        this.books = books;
    }

    public String execute() {
        String bookList = String.format("%-25s %-25s %-25d\n%-25s %-25s %-25d\n", "Muskan", "Author", 123, "Muskan Dhanda", "Author Same", 1234);
        return bookList;
    }
}
