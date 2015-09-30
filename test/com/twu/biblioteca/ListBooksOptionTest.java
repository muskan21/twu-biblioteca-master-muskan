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

        String testString = String.format("%-25s %-25s %-25d\n%-25s %-25s %-25d\n", "Muskan", "Author", 123, "Muskan Dhanda", "Author Same", 1234);
        assertEquals(testString, bookString);
    }
}
