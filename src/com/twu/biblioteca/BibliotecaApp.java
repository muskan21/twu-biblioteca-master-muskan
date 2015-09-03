package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    Display display;
    ArrayList<String> books;

    public BibliotecaApp(Display display, ArrayList<String> books) {
        this.display = display;
        this.books = books;
    }

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<String>();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Display(), books);
        bibliotecaApp.start();
    }

    public void start() {
         display.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
    }

    public void initializeBooks() {
        books.add("Gone Girl");
        books.add("Immortals Of Meluha");
        books.add("Secrets Of Nagas");
        books.add("Pragmatic Programmer");
        books.add("Let Us Java");
    }
}
