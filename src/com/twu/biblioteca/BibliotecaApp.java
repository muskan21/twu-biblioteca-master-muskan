package com.twu.biblioteca;

public class BibliotecaApp {
    Display display;

    public BibliotecaApp(Display display) {
        this.display = display;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Display());
        bibliotecaApp.start();
    }

    public void start() {
         display.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
    }
}
