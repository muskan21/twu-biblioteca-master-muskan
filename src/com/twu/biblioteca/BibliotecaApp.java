package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private BookList books;
    private MainMenu mainMenu;

    public BibliotecaApp(BookList books, MainMenu mainMenu) {
        this.books = books;
        this.mainMenu = mainMenu;
    }

    public static void main(String[] args) {

        ArrayList<Book> bookslist = new ArrayList<Book>();
        initializeBooksList(bookslist);
        BookList books = new BookList(bookslist);
        MainMenu mainMenu = new MainMenu();
        initializeMainMenu(mainMenu);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books, mainMenu);
        bibliotecaApp.start();
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        int choice;
        do {
            mainMenu.display();
            Scanner scanner = new Scanner(System.in);
            choice = mainMenu.inputMenuChoice(scanner);
            if(choice == 1)
                books.display();
            else
                books.CheckOutBook();
        }while(choice == 1 || choice == 2);
    }

    public void welcomeMessage(String message) {
        System.out.println(message);
    }

    private static void initializeMainMenu(MainMenu mainMenu) {
        mainMenu.addOption("List Books.");
        mainMenu.addOption("Exit.");
    }

    private static void initializeBooksList(ArrayList<Book> bookslist) {
        bookslist.add(new Book(1, "Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book(2, "Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book(3, "Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book(4, "Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book(5, "Let Us Java", "Yashavant Kanetkar", 2012));
    }
}
