package com.twu.biblioteca;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private ArrayList<String> options;
    private int noOfOptions;

    public MainMenu() {
        options = new ArrayList<String>();
        noOfOptions = 0;
    }

    public void addOption(String option) {
        noOfOptions++;
        options.add(noOfOptions+". "+option);
    }

    public int getNoOfOptions() {
        return noOfOptions;
    }

    public void display() {
        System.out.println("Main Menu : ");
        for (String option: options) {
            System.out.println(option);
        }
    }

    public int inputMenuChoice(Scanner read) {
        Scanner scanner = read;
        String input = scanner.nextLine();
        int inputChoice = Integer.parseInt(input);
        if(inputChoice == 1) {
            return inputChoice;
        }
        else {
            inputChoice = inputMenuChoice(read);
        }
        return inputChoice;
    }
}
