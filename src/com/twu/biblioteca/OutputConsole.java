//Responsible for printing the desied output on the console.
package com.twu.biblioteca;

import java.io.PrintStream;

public class OutputConsole {
    private PrintStream printStream;

    public OutputConsole(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void display(String message) {
        printStream.println(message);
    }
}
