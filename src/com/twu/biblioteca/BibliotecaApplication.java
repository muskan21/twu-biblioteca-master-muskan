package com.twu.biblioteca;

public class BibliotecaApplication {
    private MainMenu mainMenu;
    private InputConsole inputConsole;
    private Interpreter interpreter;
    private OutputConsole out;

    public BibliotecaApplication(MainMenu mainMenu, InputConsole inputConsole, Interpreter interpreter, OutputConsole outputConsole) {
        this.mainMenu = mainMenu;
        this.inputConsole = inputConsole;
        this.interpreter = interpreter;
        this.out = outputConsole;
    }

    public void start() {
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        do {
            out.display("\n");
            out.display(mainMenu.formattedMenu());
            String input = inputConsole.getInput();
            interpreter.interpret(input);
        }while(true);
    }

    public void welcomeMessage(String message) {
        out.display(message);
    }
}
