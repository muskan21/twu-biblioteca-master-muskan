package com.twu.biblioteca;

import java.util.Scanner;

public class InputConsole {
    Scanner scanner;

    public InputConsole() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
