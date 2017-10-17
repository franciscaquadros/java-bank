package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.managers.JpaSessionManager;
import org.academiadecodigo.javabank.managers.JpaTransactionManager;
import org.academiadecodigo.javabank.managers.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.JpaCustomerDao;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.jpa.JpaAccountService;
import org.academiadecodigo.javabank.services.jpa.JpaCustomerService;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private AuthServiceImpl authService;
    private JpaCustomerService customerService;
    private JpaAccountService accountService;
    private JpaAccountDao accountDao;
    private JpaCustomerDao customerDao;

    private JpaTransactionManager transactionManager;
    private JpaSessionManager sessionManager;


    public Controller wireObjects() {

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire services
        authService.setCustomerService(customerService);

        //Set DAOs
        customerService.setCustomerDao(customerDao);
        accountService.setAccountDao(accountDao);

        //Set managers
        transactionManager.setSessionManager(sessionManager);
        customerService.setTransactionManager(transactionManager);
        accountService.setTransactionManager(transactionManager);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
        loginController.setAuthService(authService);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        mainController.setAuthService(authService);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceView.setBalanceController(balanceController);
        balanceController.setView(balanceView);
        balanceController.setCustomerService(customerService);
        balanceController.setAuthService(authService);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setAccountService(accountService);
        newAccountController.setAuthService(authService);
        newAccountController.setAccountFactory(new AccountFactory());
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
        depositController.setAuthService(authService);
        depositController.setAccountService(accountService);
        depositController.setCustomerService(customerService);
        depositController.setView(depositView);
        withdrawalController.setAuthService(authService);
        withdrawalController.setCustomerService(customerService);
        withdrawalController.setAccountService(accountService);
        withdrawalController.setView(withdrawView);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // setup the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);

        return loginController;
    }

    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public void setCustomerService(JpaCustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(JpaAccountService accountService) {
        this.accountService = accountService;
    }

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setCustomerDao(JpaCustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setTransactionManager(JpaTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setSessionManager(JpaSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
