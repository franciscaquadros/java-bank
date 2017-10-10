package org.academiadecodigo.javabank.view;


import org.academiadecodigo.javabank.controller.MainController;

public class MainView extends AbstractView {

    private MainController mainController;

    @Override
    public void show() {
        mainController.showMenu(prompt);
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


}
