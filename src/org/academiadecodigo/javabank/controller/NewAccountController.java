package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

public class NewAccountController extends AbstractController {

    private AccountService accountService;
    private Integer newAccountId;

    @Override
    public void init() {

        newAccountId = accountService.createAccount();
        super.init();
    }


    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


}
