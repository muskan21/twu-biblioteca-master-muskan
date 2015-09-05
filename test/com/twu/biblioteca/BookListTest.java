package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void initializeBooksShouldAddTheBooksToTheList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone girl","Gyllian Flynn", 2012));
        BookList bookList = new BookList(books);

        assertEquals(1, bookList.size());
    }

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        BookList bookList = new BookList(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bookList.display();

        assertEquals("Gone Girl\t\tGillian Flynn\t\t2012\n", out.toString());
        System.setOut(System.out);
    }
}