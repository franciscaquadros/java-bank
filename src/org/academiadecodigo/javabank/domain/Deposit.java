package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;

public class Deposit implements Option {

    @Override
    public void execute(Customer c1) {

        IntegerInputScanner intScanner = new IntegerInputScanner();
        //create a new prompt
        Prompt prompt = new Prompt(System.in, System.out);

        System.out.println("In which account do you wish to make the deposit?");
        int accountId = prompt.getUserInput(intScanner);
        System.out.println("Which is the amount of the deposit?");
        int amount = prompt.getUserInput(intScanner);

        c1.getAccountManager().deposit(accountId, amount);
        System.out.println(c1.getBalance());

    }
}
