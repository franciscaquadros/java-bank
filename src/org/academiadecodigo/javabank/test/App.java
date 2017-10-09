package org.academiadecodigo.javabank.test;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.*;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class App {

    public static void main(String[] args) {

        AccountManager ac1 = new AccountManager();
        Customer c1 = new Customer();
        c1.setAccountManager(ac1);
        c1.openAccount(AccountType.CHECKING);

        //Show menu
        UserInterface u = new UserInterface();
        //Receive user input
        int userInput= u.showUserInterface();

        while (userInput != 5) {

            if (userInput == 1) {
                Deposit deposit = new Deposit();
                deposit.execute(c1);
            }

            if (userInput == 2) {
                Withdraw withdraw = new Withdraw();
                withdraw.execute(c1);
            }

            if (userInput == 3) {
                Transfer transfer = new Transfer();
                transfer.execute(c1);
            }

            if (userInput == 4){

            }

            userInput= u.showUserInterface();
        }
    }
}