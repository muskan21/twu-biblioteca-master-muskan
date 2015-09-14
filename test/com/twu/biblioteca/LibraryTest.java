package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

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
    public void shouldNotPrintTheBooksOnConsoleWhichHaveBeenCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        library.checkOutBook("Harry Potter");
        library.display();

        assertEquals("Book Name                      Book Author                    Year Of Publish               \n\nGone Girl                      Gillian Flynn                  2012                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        String available = library.checkOutBook("Gone girl");

        assertEquals("Thank You! Enjoy The Book.", available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        String available = library.checkOutBook("Harry potter");

        assertEquals("That Book Is Not Available!", available);
    }

    @Test
    public void listOfAvailableBooksShouldNotHaveTheCheckedOutBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        library.display();

        System.setOut(System.out);
        library.checkOutBook("Harry Potter");

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream1));
        library.display();

        assertNotEquals(byteArrayOutputStream.toString(), byteArrayOutputStream1.toString());
    }

    @Test
    public void listOfAvailableBooksRemainsSameIfBookNotCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        library.display();

        System.setOut(System.out);
        library.checkOutBook("Bleh Book");

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream1));
        library.display();

        assertEquals(byteArrayOutputStream.toString(), byteArrayOutputStream1.toString());

        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void hasTheNewListOfAvailableBooksIfValidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);

        library.checkOutBook("Gone girl");
        String returnString = library.returnBook("Gone girl");

        assertEquals("Thank You for returning the book.", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotHaveTheNewListOfAvailableBooksIfInvalidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);

        library.checkOutBook("Harry Potter");
        String returnString = library.returnBook("Harry");

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotReturnTheBookIfAlreadyAvailableBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);

        String returnString = library.returnBook("Harry potter");

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }
}