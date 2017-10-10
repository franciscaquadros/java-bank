package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.services.CustomerService;

public abstract class AbstractView implements View {

    protected Prompt prompt;
    protected Controller controller;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public Controller getController(){return controller;}

}
