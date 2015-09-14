package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {
    private MainMenu mainMenu;
    private InputConsole inputConsole;
    private Interpreter interpreter;
    private OutputConsole out;

    public BibliotecaApp(MainMenu mainMenu, Interpreter interpreter, OutputConsole outputConsole) {
        this.mainMenu = mainMenu;
        this.inputConsole = new InputConsole();
        this.interpreter = interpreter;
        this.out = outputConsole;
    }

    public static void main(String[] args) {

        ArrayList<Book> bookslist = new ArrayList<Book>();
        initializeBooksList(bookslist);
        Library books = new Library(bookslist);
        MainMenu mainMenu = new MainMenu();
        initializeMainMenu(mainMenu);
        OutputConsole out = new OutputConsole(new PrintStream(System.out));
        Interpreter interpreter = new Interpreter(books, new InputConsole(), out);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(mainMenu, interpreter, out);
        bibliotecaApp.start();
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        do {
            out.display("");
            out.display(mainMenu.formattedMenu());
            String input = inputConsole.getInput();
            interpreter.interpret(input);
        }while(true);
    }

    public void welcomeMessage(String message) {
        out.display(message);
    }

    private static void initializeMainMenu(MainMenu mainMenu) {
        mainMenu.addOption("List Books.");
        mainMenu.addOption("Check Out Book.");
        mainMenu.addOption("Return Book.");
        mainMenu.addOption("Exit.");
    }

    private static void initializeBooksList(ArrayList<Book> bookslist) {
        bookslist.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book("Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book("Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book("Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book("Let Us Java", "Yashavant Kanetkar", 2012));
    }
}
