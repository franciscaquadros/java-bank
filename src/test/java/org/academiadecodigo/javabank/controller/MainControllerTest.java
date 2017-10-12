package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


public class MainControllerTest {

    private MainController mainController;
    private View view;

    @Before
    public void setupUp(){
        mainController = new MainController();
        view = Mockito.mock(View.class);
        mainController.setView(view);

    }

    @Test
    public void initTest(){
        mainController.init();
        Mockito.verify(view).show();
    }

    @Test
    public void onMenuSelectionQuit(){


    }
}
