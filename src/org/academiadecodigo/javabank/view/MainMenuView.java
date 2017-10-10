package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.MainMenuController;
import org.academiadecodigo.javabank.controller.Operation;
import org.academiadecodigo.javabank.utils.Messages;

import java.util.HashMap;
import java.util.Map;

public class MainMenuView implements View{

    private Prompt prompt;
    private MenuInputScanner mainMenu;
    private MainMenuController mainController;

    public void show() {
        mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);
        mainController.setMenuOption(prompt.getUserInput(mainMenu));
    }

    public void setController(MainMenuController mainController){this.mainController=mainController;}


}