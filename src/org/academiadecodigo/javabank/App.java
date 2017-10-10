package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LogInController;
import org.academiadecodigo.javabank.utils.BootStrap;
import org.academiadecodigo.javabank.view.BankApplication;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.managers.AccountManager;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);
        LogInController logInController = new LogInController();

        Customer c1 = new Customer(4, "Francisca");

        bank.addCustomer(c1);

        BootStrap bootStrap = new BootStrap();
        bootStrap.start();

        bootStrap.getLoginController().init();


        //BankApplication bankApplication = new BankApplication(bank);
        //bankApplication.start();


    }
}
