package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.View;

public abstract class AbstractController implements Controller {

    protected View view;
    protected CustomerService customerService;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
}
