package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {
    private MainMenu mainMenu;
    private InputConsole inputConsole;
    private Interpreter interpreter;
    private OutputConsole outputConsole;
    private RolesFactory rolesFactory;

    public BibliotecaApplication(MainMenu mainMenu, InputConsole inputConsole, Interpreter interpreter, OutputConsole outputConsole, RolesFactory rolesFactory) {
        this.mainMenu = mainMenu;
        this.inputConsole = inputConsole;
        this.interpreter = interpreter;
        this.outputConsole = outputConsole;
        this.rolesFactory = rolesFactory;
    }

    public void start() {
        ArrayList<String> availableOptions = new ArrayList<String>();
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST));
        availableOptions = user.canPerformOperations();
        welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        do {
            outputConsole.display("\n");
            outputConsole.display(mainMenu.formattedMenu(availableOptions));
            String input = inputConsole.getInput();
            availableOptions = interpreter.interpret(input);
        } while(true);
    }

    public void welcomeMessage(String message) {
        outputConsole.display(message);
    }
}
