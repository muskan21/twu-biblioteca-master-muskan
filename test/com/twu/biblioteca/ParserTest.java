package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class ParserTest {

    @Test
    public void shouldReturnListBooksOptionObjectOnInputBeing1() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("1");

        assertEquals(menuOptions.getClass(), ListBooksOption.class);
    }

    @Test
    public void shouldNotReturnAnyOtherObjectExceptListBooksOptionObject() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("1");

        assertNotEquals(menuOptions.getClass(), Parser.class);
    }

    @Test
    public void shouldReturnInvalidOptionObjectIfInputIs3() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("4");

        assertEquals(menuOptions.getClass(), InvalidOption.class);
    }

    @Test
    public void shouldReturnInvalidOptionObjectIfInputIsNot1Or2() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Muskan", "Author", 123));
        books.add(new Book("Muskan Dhanda", "Author Same", 1234));
        BookLibrary bookLibrary = new BookLibrary(books);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("Not 1 Or 2");

        assertEquals(menuOptions.getClass(), InvalidOption.class);
    }

    @Test
    public void shouldReturnListMoviesOptionObjectOnInputBeing2() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Muskan D", 1234, "Director", "10"));
        movies.add(new Movie("Muskan Dhanda", 123, "Director Same", "unrated"));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("2");

        assertEquals(menuOptions.getClass(), ListMoviesOption.class);
    }

    @Test
    public void shouldReturnCheckOutMovieOptionObjectOnInputBeing3() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Parser parser = new Parser(bookLibrary, movieLibrary, outputConsole, inputConsole);

        MenuOptions menuOptions = parser.parse("3");

        assertEquals(menuOptions.getClass(), CheckOutMovieOption.class);
    }
}
