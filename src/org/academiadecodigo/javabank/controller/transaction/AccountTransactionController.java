package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.model.Customer;

public interface AccountTransactionController extends Controller {

    void submitTransaction(int accountId, double amount);

    Customer getLogInCustomer();

}
