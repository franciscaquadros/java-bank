package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.GetBalanceController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.utils.Messages;

import java.text.DecimalFormat;
import java.util.Set;

public class GetBalanceView implements View{

    private Bank bank;
    DecimalFormat df = new DecimalFormat("#.##");
    private GetBalanceController balanceController;

    public void show(){
        System.out.println("\n" + bank.getCustomer(bank.getAccessingCustomerId()).getName() + Messages.BALANCE_MESSAGE + "\n");

        for (Account account: balanceController.getAccounts()) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(bank.getCustomer(bank.getAccessingCustomerId()).getBalance()));

    }
}
