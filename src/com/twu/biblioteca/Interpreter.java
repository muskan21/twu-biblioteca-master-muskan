package com.twu.biblioteca;

import java.util.ArrayList;

public class Interpreter {
    private BookLibrary books;
    private MovieLibrary movies;
    private InputConsole inputConsole;
    private OutputConsole out;
    private User currentUser;
    private BibliotecaAdmin bibliotecaAdmin;

    public Interpreter(BookLibrary books, MovieLibrary movies, InputConsole inputConsole, OutputConsole out, User currentUser, BibliotecaAdmin bibliotecaAdmin) {
        this.books = books;
        this.movies = movies;
        this.inputConsole = inputConsole;
        this.out = out;
        this.currentUser = currentUser;
        this.bibliotecaAdmin = bibliotecaAdmin;
    }

    public ArrayList<String> interpret(String inputChoice1) {
        String inputChoice = inputChoice1.toUpperCase();
        if(!currentUser.canPerformOperations().contains(inputChoice)) {
            out.display("Select A Valid Option!!");
            return currentUser.canPerformOperations();
        }
        switch (inputChoice) {
            case "1":
                out.display(books.formattedListOfAvailableBooks());
                return currentUser.canPerformOperations();

            case "2":
                out.display(movies.formattedListOfAvailableMovies());
                return currentUser.canPerformOperations();

            case "3":
                out.display("Enter The Name Of The Movie To Check Out : ");
                String checkedOutMovie = inputConsole.getInput();
                movies.checkOutMovie(checkedOutMovie);
                return currentUser.canPerformOperations();

            case "4":
                out.display("Enter The Name Of The Book To Check Out : ");
                String checkedOutBook = inputConsole.getInput();
                out.display(books.checkOutBook(checkedOutBook, currentUser));
                return currentUser.canPerformOperations();

            case "5":
                out.display("Enter The Name Of The Book To Return : ");
                String returnBook = inputConsole.getInput();
                out.display(books.returnBook(returnBook, currentUser));
                return currentUser.canPerformOperations();

            case "6":
                return currentUser.canPerformOperations();

            case "7":
                return currentUser.canPerformOperations();

            case "L":
                out.display("Enter Library Number : ");
                String libraryNumber = inputConsole.getInput();
                out.display("Enter password : ");
                String password = inputConsole.getInput();
                currentUser = bibliotecaAdmin.login(libraryNumber, password);
                return currentUser.canPerformOperations();

            case "0":
                currentUser = bibliotecaAdmin.logout();
                return currentUser.canPerformOperations();

            case "Q":
                System.exit(0);

            default:
                out.display("Select A Valid Option!!");
                return currentUser.canPerformOperations();
        }
    }
}
