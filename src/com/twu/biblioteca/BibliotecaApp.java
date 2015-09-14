package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {

        ArrayList<Book> bookslist = new ArrayList<Book>();
        initializeBooksList(bookslist);
        BookLibrary books = new BookLibrary(bookslist);
        MainMenu mainMenu = initializeMainMenu();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(System.out));
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        Interpreter interpreter = new Interpreter(books, inputConsole, outputConsole);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(mainMenu, inputConsole, interpreter, outputConsole);


        bibliotecaApplication.start();
    }

    private static MainMenu initializeMainMenu() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books.");
        options.add("2. Check Out Book.");
        options.add("3. Return Book.");
        options.add("4. Exit.");
        MainMenu mainMenu = new MainMenu(options);
        return mainMenu;
    }

    private static void initializeBooksList(ArrayList<Book> bookslist) {
        bookslist.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book("Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book("Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book("Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book("Let Us Java", "Yashavant Kanetkar", 2012));
    }
}
