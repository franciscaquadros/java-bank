package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controller.BalanceOperation;
import org.academiadecodigo.javabank.controller.NewAccountOperation;
import org.academiadecodigo.javabank.controller.Operation;
import org.academiadecodigo.javabank.controller.transaction.DepositOperation;
import org.academiadecodigo.javabank.controller.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.utils.Messages;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

    private Prompt prompt;
    private Bank bank;

    public BankApplication(Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in, System.out);
    }



    public Bank getBank() {
        return bank;
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public int getAcessingCustomerId() {return bank.getAccessingCustomerId();}
}
