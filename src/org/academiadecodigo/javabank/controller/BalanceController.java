package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;

public class BalanceController extends AbstractController {

    private AuthenticationService authenticationService;

    public CustomerService getCustomerService(){
        return customerService;
    }

    public Customer getLoginCustomer(){
        return authenticationService.getAuthenticatedCustomer();
    }
}
