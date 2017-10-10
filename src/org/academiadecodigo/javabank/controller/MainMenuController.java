package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;

import java.util.Map;

public class MainMenuController implements Controller{

    private View mainMenuView;
    private int menuOption;
    private Map<Integer, UserOptions> optionsMap;
    private Map<Integer, Controller> controllerMap;


    public void init() {
        mainMenuView.show();
        checkOption();
    }

    public void checkOption(){

        if (optionsMap.get(menuOption)== UserOptions.QUIT) {
            return;
        }

        controllerMap.get(optionsMap.get(menuOption)).init();
        checkOption();

    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    public void setOptionsMap(Map optionsMap){
        this.optionsMap = optionsMap;
    }

    public void setControllerMap(Map controllerMap){
        this.controllerMap = controllerMap;
    }

    public void setView(View mainMenuView) {this.mainMenuView = mainMenuView;}

}
