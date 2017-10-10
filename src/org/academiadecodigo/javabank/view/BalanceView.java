package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import javax.swing.plaf.basic.BasicLookAndFeel;
import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView implements View {

    DecimalFormat df = new DecimalFormat("#.##");
    private BalanceController balanceController;


    @Override
    public void show() {
        showBalance();
    }

    private void showBalance() {

        Customer customer = balanceController.getLoginCustomer();
        System.out.println("\n" + customer.getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));
    }

    public void setBalanceController(BalanceController balanceController){
        this.balanceController = balanceController;
    }
}
