package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.view.DepositView;

public class DepositController implements Controller {

    private DepositView view;

    @Override
    public void init() {
        view.show();

    }
}
