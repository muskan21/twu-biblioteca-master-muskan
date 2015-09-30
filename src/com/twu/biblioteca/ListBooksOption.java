package com.twu.biblioteca;

public class ListBooksOption implements MenuOptions {
    private BookLibrary books;

    public ListBooksOption(BookLibrary books) {
        this.books = books;
    }

    public String execute() {
        String bookList = books.formattedListOfAvailableBooks();
        return bookList;
    }
}
