package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class UserInterface {

    //MENU
    public int showUserInterface() {

        //Define the menu options
        String[] options = {"Deposit", "Withdraw", "Transfer", "Get Balance", "Exit"};
        //create a new prompt
        Prompt prompt = new Prompt(System.in, System.out);
        //instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);
        //menu prompt message
        scanner.setMessage("Choose an option: ");
        //force the user to introduce a valid input
        int userInput = prompt.getUserInput(scanner);

        return userInput;

    }
}
