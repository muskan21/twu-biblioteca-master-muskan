package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ParserTest {

    @Test
    public void shouldReturnListBooksOptionObjectOnInputBeing1() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        Parser parser = new Parser(bookLibrary);

        MenuOptions menuOptions = parser.parse("1");

        assertEquals(menuOptions.getClass(), ListBooksOption.class);
    }

    @Test
    public void shouldNotReturnAnyOtherObjectExceptListBooksOptionObject() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        Parser parser = new Parser(bookLibrary);

        MenuOptions menuOptions = parser.parse("1");

        assertNotEquals(menuOptions.getClass(), Parser.class);
    }

    @Test
    public void shouldReturnInvalidOptionObjectIfInputIsNot1() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        Parser parser = new Parser(bookLibrary);

        MenuOptions menuOptions = parser.parse("2");

        assertEquals(menuOptions.getClass(), InvalidOption.class);
    }
}
