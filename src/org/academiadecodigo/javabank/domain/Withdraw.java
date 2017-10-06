package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;

public class Withdraw implements Option{

    @Override
    public void execute(Customer c1){

        IntegerInputScanner intScanner = new IntegerInputScanner();
        //create a new prompt
        Prompt prompt = new Prompt(System.in, System.out);

        System.out.println("From which account do you wish to withdraw?");
        int accountId = prompt.getUserInput(intScanner);
        System.out.println("Which is the amount of the withdraw?");
        int amount = prompt.getUserInput(intScanner);

        c1.getAccountManager().withdraw(accountId, amount);
        System.out.println(c1.getBalance());

    }
}
