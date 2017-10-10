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

    private BalanceController balanceController;


    @Override
    public void show() {
        balanceController.showBalance();
    }

    public void setBalanceController(BalanceController balanceController){
        this.balanceController = balanceController;
    }
}
