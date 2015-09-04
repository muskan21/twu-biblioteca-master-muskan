package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    ArrayList<String> books;

    public BibliotecaApp(ArrayList<String> books) {
        this.books = books;
    }

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<String>();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);
        bibliotecaApp.start();
    }

    public void start() {
         welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
    }

    public void initializeBooks() {
        books.add("Gone Girl");
        books.add("Immortals Of Meluha");
        books.add("Secrets Of Nagas");
        books.add("Pragmatic Programmer");
        books.add("Let Us Java");
    }

    public void welcomeMessage(String message) {
        System.out.println(message);
    }

    public void listOfBooks() {
        for(String book : books) {
            System.out.println(book);
        }
    }
}
