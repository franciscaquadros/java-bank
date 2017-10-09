package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.view.GetBalanceView;

import java.util.Set;

public class GetBalanceController implements Controller{

    private GetBalanceView balanceView;
    private Bank bank;
    private MainMenuController mainMenuController;

    public void init() {
        balanceView.show();
        mainMenuController.init();
    }

    public Set<Account> getAccounts(){
        Set<Account> accounts = bank.getCustomer(bank.getAccessingCustomerId()).getAccounts();
        return accounts;

    }
}
