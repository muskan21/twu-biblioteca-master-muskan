package com.twu.biblioteca;

import java.io.PrintStream;

public class OutputConsole {
    PrintStream printStream;

    public OutputConsole(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void display(String message) {
        printStream.println(message);
    }
}
