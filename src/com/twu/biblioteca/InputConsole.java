package com.twu.biblioteca;

import java.util.Scanner;

public class InputConsole {
    Scanner scanner;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
