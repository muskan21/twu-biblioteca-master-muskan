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
        bookslist.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book("Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book("Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book("Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book("Let Us Java", "Yashavant Kanetkar", 2012));
        BookList books = new BookList(bookslist);
        MainMenu mainMenu = new MainMenu();
        mainMenu.addOption("List Books.");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books, mainMenu);
        bibliotecaApp.start();
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        mainMenu.display();
        Scanner scanner = new Scanner(System.in);
        mainMenu.inputMenuChoice(scanner);
        books.display();
    }

    public void welcomeMessage(String message) {
        System.out.println(message);
    }
}
