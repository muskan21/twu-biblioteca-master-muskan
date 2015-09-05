package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private BookList books;

    public BibliotecaApp(BookList books) {
        this.books = books;
    }

    public static void main(String[] args) {

        ArrayList<Book> bookslist = new ArrayList<Book>();
        bookslist.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        bookslist.add(new Book("Immortals Of Meluha", "Amish Tripathi", 2010));
        bookslist.add(new Book("Secrets Of Nagas", "Amish Tripathi", 2011));
        bookslist.add(new Book("Pragmatic Programmer", "Andrew Hunt", 1999));
        bookslist.add(new Book("Let Us Java", "Yashavant Kanetkar", 2012));
        BookList books = new BookList(bookslist);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);
        bibliotecaApp.start();
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        books.display();
    }

    public void welcomeMessage(String message) {
        System.out.println(message);
    }
}
