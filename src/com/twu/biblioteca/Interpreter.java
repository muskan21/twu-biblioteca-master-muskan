package com.twu.biblioteca;

public class Interpreter {
    Library books;
    InputConsole inputConsole;

    public Interpreter(Library books, InputConsole inputConsole) {
        this.books = books;
        this.inputConsole = inputConsole;
    }

    public void interpret(String inputChoice) {
        switch (inputChoice) {
            case "1":
                books.display();
                break;
            case "2":
                System.out.println("Enter The Name Of The Book To Check Out : ");
                String checkedOutBook = inputConsole.getInput();
                System.out.println(books.checkOutBook(checkedOutBook));
                break;
            case "3":
                System.out.println("Enter The Name Of The Book To Return : ");
                String returnBook = inputConsole.getInput();
                System.out.println(books.returnBook(returnBook));
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Select A Valid Option!!");
        }
    }
}
