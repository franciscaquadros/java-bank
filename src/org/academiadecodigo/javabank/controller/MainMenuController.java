package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.transaction.DepositOperation;
import org.academiadecodigo.javabank.controller.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.utils.Messages;
import org.academiadecodigo.javabank.view.MainMenuView;
import org.academiadecodigo.javabank.view.UserOptions;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;

public class MainMenuController implements Controller{

    private MainMenuView mainMenuView;
    private Map<Integer, Integer> optionsMap = new HashMap<>();
    private int menuOption;


    public void init() {
        mainMenuView.show();
        optionsMap = buildOptionsMap();
    }

    public void checkOption(){

        if (optionsMap.get(menuOption)== UserOptions.QUIT.getOption()) {
            return;
        }

        optionsMap.get(menuOption).execute();
        checkOption();

    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    private Map<Integer, Integer> buildOptionsMap() {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,UserOptions.GET_BALANCE.getOption());
        map.put(2,UserOptions.DEPOSIT.getOption());
        map.put(3,UserOptions.WITHDRAW.getOption());
        map.put(4,UserOptions.OPEN_ACCOUNT.getOption());

        return map;
    }

}
