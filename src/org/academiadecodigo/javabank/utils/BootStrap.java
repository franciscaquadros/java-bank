package org.academiadecodigo.javabank.utils;

import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.view.MainMenuView;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;

import java.util.HashMap;
import java.util.Map;

public class BootStrap {

    private Map<Integer, UserOptions> optionsMap = buildOptionsMap();
    private Map<UserOptions, Controller> controllerMap = buildControllersMap();
    private MainMenuController mainMenuController;

    private Map<Integer, UserOptions> buildOptionsMap() {

        Map<Integer, UserOptions> map = new HashMap<>();
        map.put(1, UserOptions.GET_BALANCE);
        map.put(2,UserOptions.DEPOSIT);
        map.put(3,UserOptions.WITHDRAW);
        map.put(4,UserOptions.OPEN_ACCOUNT);

        return map;
    }

    private Map<UserOptions, Controller> buildControllersMap(){
        Map<UserOptions, Controller> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE,new GetBalanceController());
        map.put(UserOptions.DEPOSIT, new DepositController());
        //map.put(UserOptions.WITHDRAW, new WithdrawController());
        //map.put(UserOptions.OPEN_ACCOUNT, new AccountController());

        return map;
    }

    public void start(){

        View mainMenuView= new MainMenuView();
        MainMenuController mainMenuController = new MainMenuController();

        mainMenuController.setControllerMap(buildControllersMap());
        mainMenuController.setOptionsMap(buildOptionsMap());
        mainMenuController.setView(mainMenuView);
        //mainMenuView.setController(mainMenuController);
    }

    //public LogInController getLoginController(){
      //  return
    //}
}
