package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static final int EXIT_STATUS = Integer.MAX_VALUE;
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
        System.out.println("Enter Your Choice : ");
    }

    public int inputMenuChoice(Scanner read) {
        Scanner scanner = read;
        String input;
        int inputChoice = 0;
        do {
            input = scanner.nextLine();
            try {
                inputChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                inputChoice = 0;
            }
            finally {
                if (inputChoice == 1) {
                    return inputChoice;
                } else if(inputChoice == 2) {
                    return EXIT_STATUS;
                }
                else {
                    System.out.println("Select A Valid Option");
                    inputChoice = inputMenuChoice(read);
                }
                return inputChoice;
            }
        } while(inputChoice != 1);
    }
}
