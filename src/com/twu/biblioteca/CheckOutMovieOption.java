package com.twu.biblioteca;

public class CheckOutMovieOption implements MenuOptions {
    private OutputConsole outputConsole;
    private InputConsole inputConsole;
    private MovieLibrary movies;

    public CheckOutMovieOption(OutputConsole outputConsole, InputConsole inputConsole, MovieLibrary movies) {
        this.outputConsole = outputConsole;
        this.inputConsole = inputConsole;
        this.movies = movies;
    }

    public String execute() {
        outputConsole.display("Enter The Name Of The Movie To Check Out : ");
        String checkoutMovie = inputConsole.getInput();
        String checkOutMessage = movies.checkOutMovie(checkoutMovie);
        return "";
    }
}
