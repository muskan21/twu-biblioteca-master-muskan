package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookListTest {

    @Test
    public void initializeBooksShouldAddTheBooksToTheList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Gone girl","Gyllian Flynn", 2012));
        BookList bookList = new BookList(books);

        assertEquals(1, bookList.size());
    }

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Gone Girl","Gillian Flynn", 2012));
        BookList bookList = new BookList(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bookList.display();

        assertEquals("Serial No.      Book Name                      Book Author                    Year Of Publish               \n\n1               Gone Girl                      Gillian Flynn                  2012                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldInputBookToBeCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Gone Girl", "Gillian Flynn", 2012));
        BookList bookList = new BookList(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);

        int checkedOutBook = bookList.inputCheckedOutBook();

        assertEquals(1, checkedOutBook);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Gone Girl", "Gillian Flynn", 2012));
        BookList bookList = new BookList(books);

        boolean available = bookList.checkAvailabilityForCheckOut(1);

        assertTrue(available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Gone Girl", "Gillian Flynn", 2012));
        BookList bookList = new BookList(books);

        boolean available = bookList.checkAvailabilityForCheckOut(2);

        assertFalse(available);
    }
}