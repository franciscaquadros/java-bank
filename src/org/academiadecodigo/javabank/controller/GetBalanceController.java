package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.view.GetBalanceView;

public class GetBalanceController implements Controller{

    private GetBalanceView balanceView;

    public void init() {
        balanceView.show();

    }
}
