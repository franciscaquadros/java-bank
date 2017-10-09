package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.LogInController;
import org.academiadecodigo.javabank.controller.Operation;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.utils.Messages;

import java.util.Map;

public class LogInView implements View{

    private Prompt prompt;
    private Bank bank;
    private LogInController logInController;

    public void show(){
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        logInController.onCustmId(prompt.getUserInput(scanner));
    }

}
