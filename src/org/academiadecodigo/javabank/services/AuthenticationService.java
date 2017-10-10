package org.academiadecodigo.javabank.services;


import org.academiadecodigo.javabank.model.Customer;

public class AuthenticationService {

    private CustomerService customerService;
    private Customer authenticatedCustomer;

    public boolean authenticate(int id) {

        boolean result= customerService.getCustomerIds().contains(id);

        if(result){
            this.authenticatedCustomer = customerService.getCostumerById(id);
        }

        return result;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getAuthenticatedCustomer() {
        return authenticatedCustomer;
    }
}
