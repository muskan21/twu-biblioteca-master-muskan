//Responsible for interpreting the given input and perform the desired operations on the basis of the current user of the system.
package com.twu.biblioteca;

import java.util.ArrayList;

public class Interpreter {
    private BookLibrary books;
    private MovieLibrary movies;
    private InputConsole inputConsole;
    private OutputConsole outputConsole;
    private User currentUser;
    private BibliotecaAdmin bibliotecaAdmin;
    private Parser parser;

    public Interpreter(BookLibrary books, MovieLibrary movies, InputConsole inputConsole, OutputConsole outputConsole, User currentUser, BibliotecaAdmin bibliotecaAdmin, Parser parser) {
        this.books = books;
        this.movies = movies;
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
        this.currentUser = currentUser;
        this.bibliotecaAdmin = bibliotecaAdmin;
        this.parser = parser;
    }

    public ArrayList<String> interpret(String inputChoice1) {
        String inputChoice = inputChoice1.toUpperCase();
        if(!currentUser.canPerformOperations().contains(inputChoice)) {
            outputConsole.display("Select A Valid Option!!");
            return currentUser.canPerformOperations();
        }
        if("1".equals(inputChoice) || "2".equals(inputChoice)) {
            MenuOptions menuOptions = parser.parse(inputChoice);
            outputConsole.display(menuOptions.execute());
        }
        else if(inputChoice.equals("3")) {
            outputConsole.display("Enter The Name Of The Movie To Check Out : ");
            String checkedOutMovie = inputConsole.getInput();
            outputConsole.display(movies.checkOutMovie(checkedOutMovie));
        }
        else if(inputChoice.equals("4")) {
            outputConsole.display("Enter The Name Of The Book To Check Out : ");
            String checkedOutBook = inputConsole.getInput();
            outputConsole.display(books.checkOutBook(checkedOutBook, currentUser));
        }
        else if(inputChoice.equals("5")) {
            outputConsole.display("Enter The Name Of The Book To Return : ");
            String returnBook = inputConsole.getInput();
            outputConsole.display(books.returnBook(returnBook, currentUser));
        }
        else if(inputChoice.equals("6")) {
            outputConsole.display(currentUser.formattedUserDetails());
        }
        else if(inputChoice.equals("7")) {
            outputConsole.display(books.bookLibraryStatus());
        }
        else if(inputChoice.equals("L")) {
            outputConsole.display("Enter Library Number : ");
            String libraryNumber = inputConsole.getInput();
            outputConsole.display("Enter password : ");
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
            outputConsole.display("Select A Valid Option!!");
        }
        return currentUser.canPerformOperations();
    }
}
