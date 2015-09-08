package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

    @Test
    public void initializeBooksShouldAddTheBooksToTheList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone girl","Gyllian Flynn", 2012));
        Library library = new Library(books);

        assertEquals(1, library.size());
    }

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        Library library = new Library(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        library.display();

        assertEquals("Book Name                      Book Author                    Year Of Publish               \n\nGone Girl                      Gillian Flynn                  2012                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldInputBookToBeCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Gone Girl".getBytes());
        System.setIn(byteArrayInputStream);

        String checkedOutBook = library.inputCheckedOutBook();

        assertEquals("Gone Girl", checkedOutBook);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        boolean available = library.checkAvailabilityForCheckOut("Gone girl");

        assertTrue(available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        boolean available = library.checkAvailabilityForCheckOut("Harry potter");

        assertFalse(available);
    }

    @Test
    public void listOfAvailableBooksShouldNotHaveTheCheckedOutBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Harry Potter".getBytes());
        System.setIn(byteArrayInputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        library.display();

        System.setOut(System.out);
        library.checkOutBook();

        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library1 = new Library(books1);
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream1));
        library1.display();

        assertNotEquals(byteArrayOutputStream.toString(), byteArrayOutputStream1.toString());
    }

    @Test
    public void listOfAvailableBooksRemainsSameIfBookNotCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Bleh Book".getBytes());
        System.setIn(byteArrayInputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        library.display();

        System.setOut(System.out);
        library.checkOutBook();

        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books1.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library1 = new Library(books1);
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream1));
        library1.display();

        assertEquals(byteArrayOutputStream.toString(), byteArrayOutputStream1.toString());

        System.setOut(System.out);
        System.setIn(System.in);
    }
}