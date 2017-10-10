package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected CustomerService customerService;
    protected AuthenticationService authenticationService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Customer getLogInCustomer(){
        return authenticationService.getAuthenticatedCustomer();
    }
}
