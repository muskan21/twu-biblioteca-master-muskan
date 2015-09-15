package com.twu.biblioteca;

public class Interpreter {
    private BookLibrary books;
    private MovieLibrary movies;
    private InputConsole inputConsole;
    private OutputConsole out;

    public Interpreter(BookLibrary books, MovieLibrary movies, InputConsole inputConsole, OutputConsole out) {
        this.books = books;
        this.movies = movies;
        this.inputConsole = inputConsole;
        this.out = out;
    }

    public void interpret(String inputChoice) {
        switch (inputChoice) {
            case "1":
                out.display(books.formattedListOfAvailableBooks());
                break;
            case "4":
                out.display("Enter The Name Of The Book To Check Out : ");
                String checkedOutBook = inputConsole.getInput();
                out.display(books.checkOutBook(checkedOutBook));
                break;
            case "5":
                out.display("Enter The Name Of The Book To Return : ");
                String returnBook = inputConsole.getInput();
                out.display(books.returnBook(returnBook));
                break;
            case "2":
                out.display(movies.formattedListOfAvailableMovies());
                break;
            case "3":
                out.display("Enter The Name Of The Movie To Check Out : ");
                String checkedOutMovie = inputConsole.getInput();
                movies.checkOutMovie(checkedOutMovie);
                break;
            case "0":
                out.display("Logout.");
                break;
            case "Q":
                System.exit(0);
            default:
                out.display("Select A Valid Option!!");
        }
    }
}
