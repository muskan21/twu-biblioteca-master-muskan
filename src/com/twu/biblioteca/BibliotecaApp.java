package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {

        ArrayList<Book> booksList = initializeBooksList();
        BookLibrary books = new BookLibrary(booksList);
        ArrayList<Movie> moviesList = initializeMoviesList();
        MovieLibrary movies = new MovieLibrary(moviesList);
        MainMenu mainMenu = initializeMainMenu();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(System.out));
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        Interpreter interpreter = new Interpreter(books, movies, inputConsole, outputConsole);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(mainMenu, inputConsole, interpreter, outputConsole);


        bibliotecaApplication.start();
    }

    private static MainMenu initializeMainMenu() {
        HashMap<String, String> menuOptions = new HashMap<String, String>();
        menuOptions.put("1", "List Books.");
        menuOptions.put("2", "List Movies.");
        menuOptions.put("3", "Check Out Movies.");
        menuOptions.put("4", "Check Out Book.");
        menuOptions.put("5", "Return Book.");
        menuOptions.put("6", "User Details.");
        menuOptions.put("7", "Book Details.");
        menuOptions.put("L", "Login.");
        menuOptions.put("0", "Logout.");
        menuOptions.put("Q", "Quit.");
        MainMenu mainMenu = new MainMenu(menuOptions);
        return mainMenu;
    }

    private static ArrayList<Book> initializeBooksList() {
        ArrayList<Book> bookslist = new ArrayList<Book>();
        bookslist.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book("Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book("Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book("Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book("Let Us Java", "Yashavant Kanetkar", 2012));
        return bookslist;
    }

    private static ArrayList<Movie> initializeMoviesList() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Avengers", 2015, "Flynn", "4"));
        movies.add(new Movie("Iron Man", 2012, "Tony Stark", "4"));
        movies.add(new Movie("Super Man", 2000, "Clark", "unrated"));
        movies.add(new Movie("Spider Man", 2010, "Peter Parker", "2.3"));
        movies.add(new Movie("Gone girl", 2014, "Gillian Flynn", "4"));
        return movies;
    }
}
