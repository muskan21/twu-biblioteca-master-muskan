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
        if(inputChoice.equals("1")) {
            out.display(books.formattedListOfAvailableBooks());
        }
        else if(inputChoice.equals("2")) {
            out.display(movies.formattedListOfAvailableMovies());
        }
        else if(inputChoice.equals("3")) {
            out.display("Enter The Name Of The Movie To Check Out : ");
            String checkedOutMovie = inputConsole.getInput();
            out.display(movies.checkOutMovie(checkedOutMovie));
        }
        else if(inputChoice.equals("4")) {
            out.display("Enter The Name Of The Book To Check Out : ");
            String checkedOutBook = inputConsole.getInput();
            out.display(books.checkOutBook(checkedOutBook, currentUser));
        }
        else if(inputChoice.equals("5")) {
            out.display("Enter The Name Of The Book To Return : ");
            String returnBook = inputConsole.getInput();
            out.display(books.returnBook(returnBook, currentUser));
        }
        else if(inputChoice.equals("6")) {
            out.display(currentUser.formattedUserDetails());
        }
        else if(inputChoice.equals("7")) {
            out.display(books.bookLibraryStatus());
        }
        else if(inputChoice.equals("L")) {
            out.display("Enter Library Number : ");
            String libraryNumber = inputConsole.getInput();
            out.display("Enter password : ");
            String password = inputConsole.getInput();
            currentUser = bibliotecaAdmin.login(libraryNumber, password);
        }
        else if(inputChoice.equals("0")) {
            currentUser = bibliotecaAdmin.logout();
        }
        else if(inputChoice.equals("Q")) {
            System.exit(0);
        }
        else {
            out.display("Select A Valid Option!!");
        }
        return currentUser.canPerformOperations();
    }
}
