//prints the welcome message on starting the application and invokes different methods for displaying and getting input for menu and then interpreting the same.
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {
    public static final String UNKNOWN_USERNAME = "";
    public static final String UNKNOWN_EMAIL = "";
    public static final int UNKNOWN_CONTACT_NUMBER = 0;
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
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), UNKNOWN_USERNAME, UNKNOWN_EMAIL, UNKNOWN_CONTACT_NUMBER);
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
