package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.Messages;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceController extends AbstractController {

    private AuthenticationService authenticationService;
    DecimalFormat df = new DecimalFormat("#.##");

    public CustomerService getCustomerService(){
        return customerService;
    }

    //public Customer getLoginCustomer(){
     //   return authenticationService.getAuthenticatedCustomer();
    //}

    public void showBalance() {

        Customer customer = authenticationService.getAuthenticatedCustomer();
        System.out.println("\n" + customer.getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));
    }
}
