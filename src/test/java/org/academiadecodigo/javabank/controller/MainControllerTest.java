package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class MainControllerTest {

    private MainController mainController;
    private View view;
    private Map<Integer, Controller> controllerMap = new HashMap<>();
    private Controller controller1;
    private Controller controller2;

    @Before
    public void setupUp(){
        mainController = new MainController();
        view = Mockito.mock(View.class);
        mainController.setView(view);

        controller1 = Mockito.mock(BalanceController.class);
        controller2 = Mockito.mock(DepositController.class);

        controllerMap.put(UserOptions.GET_BALANCE.getOption(), controller1);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), controller2);
        mainController.setControllerMap(controllerMap);

    }

    @Test
    public void initTest(){
        mainController.init();
        Mockito.verify(view).show();
    }

    @Test
    public void onMenuSelectionQuitTest(){
        mainController.onMenuSelection(UserOptions.QUIT.getOption());



    }
}
