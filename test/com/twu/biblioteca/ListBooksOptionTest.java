package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBooksOptionTest {

    @Test
    public void shouldReturnTheListOfBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        ListBooksOption listBooks = new ListBooksOption(bookLibrary);

        String bookString = listBooks.execute();

        String testString = String.format("%-25s %-25s %-25s\n\n%-25s %-25s %-25d\n%-25s %-25s %-25d\n", "Book Name", "Book Author", "Year Of Publish", "Muskan", "Author", 123, "Muskan Dhanda", "Author Same", 1234);
        assertEquals(testString, bookString);
    }

    @Test
    public void shouldReturnTheAvailableListOfBooksInTheLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan D", "Author 1", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        ListBooksOption listBooks = new ListBooksOption(bookLibrary);

        String bookString = listBooks.execute();

        String testString = String.format("%-25s %-25s %-25s\n\n%-25s %-25s %-25d\n%-25s %-25s %-25d\n", "Book Name", "Book Author", "Year Of Publish", "Muskan D", "Author 1", 123, "Muskan Dhanda", "Author Same", 1234);
        assertEquals(testString, bookString);
    }
}
