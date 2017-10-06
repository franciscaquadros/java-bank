package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;

public class Transfer implements Option {

    @Override
    public void execute(Customer c){

        IntegerInputScanner intScanner = new IntegerInputScanner();
        //create a new prompt
        Prompt prompt = new Prompt(System.in, System.out);

        System.out.println("From which account do you wish to transfer?");
        int srcAccountId = prompt.getUserInput(intScanner);
        System.out.println("To which account do you wish to transfer?");
        int dstAccountId = prompt.getUserInput(intScanner);
        System.out.println("Which is the amount of the transfer?");
        int amount = prompt.getUserInput(intScanner);

        c.getAccountManager().transfer(srcAccountId, dstAccountId, amount);
    }
}
