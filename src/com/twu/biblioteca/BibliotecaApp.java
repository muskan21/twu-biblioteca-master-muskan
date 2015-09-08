package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Library books;
    private MainMenu mainMenu;
    private InputConsole inputConsole;

    public BibliotecaApp(Library books, MainMenu mainMenu) {
        this.books = books;
        this.mainMenu = mainMenu;
        this.inputConsole = new InputConsole();
    }

    public static void main(String[] args) {

        ArrayList<Book> bookslist = new ArrayList<Book>();
        initializeBooksList(bookslist);
        Library books = new Library(bookslist);
        MainMenu mainMenu = new MainMenu();
        initializeMainMenu(mainMenu);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books, mainMenu);
        bibliotecaApp.start();
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        int choice;
        do {
            System.out.println();
            mainMenu.display();
            String input = inputConsole.getInput();
            choice = mainMenu.validateInputMenuChoice(input);
            if(choice == 1)
                books.display();
            else if(choice == 2) {
                System.out.println("Enter The Name Of The Book To Check Out : ");
                String checkedOutBook = inputConsole.getInput();
                System.out.println(books.checkOutBook(checkedOutBook));
            }
        }while(true);
    }

    public void welcomeMessage(String message) {
        System.out.println(message);
    }

    private static void initializeMainMenu(MainMenu mainMenu) {
        mainMenu.addOption("List Books.");
        mainMenu.addOption("Check Out Book.");
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
