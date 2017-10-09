package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.View;

public class LogInController implements Controller {

    private Bank bank;
    private View view;
    private int CustomerID;
    private MainMenuController mainMenuController;

    public void init() {
        view.show();
        bank.setAccessingCustomer(CustomerID);
        mainMenuController.init();
    }

    public void onCustmId(int id){
        this.CustomerID = id;
    }


}
