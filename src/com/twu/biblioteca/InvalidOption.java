package com.twu.biblioteca;

public class InvalidOption implements MenuOptions{

    private String invalidOptionMessage;

    public InvalidOption(String invalidOptionMessage) {
        this.invalidOptionMessage = invalidOptionMessage;
    }

    public String execute() {
        return invalidOptionMessage;
    }
}
