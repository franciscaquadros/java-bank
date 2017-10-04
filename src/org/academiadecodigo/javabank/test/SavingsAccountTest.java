package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.AccountType;
import org.academiadecodigo.javabank.domain.SavingsAccount;

public class SavingsAccountTest {

    public boolean test(){

        Account account = new SavingsAccount(1, 10);

        //account should start with balance 0
        if(account.getBalance() != 0){
            return false;
        }

        // we should be able to deposit money in account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }

        // we should not be able to take money from account if it results in a balance lower than 100
        account.debit(40);
        if (account.getBalance() != 80) {
            return  false;
        }

        //the type of the account must be SAVINGS
        if (account.getAccountType() != AccountType.SAVINGS){
            return false;
        }

        //it should be possible to add interest
        if (account instanceof SavingsAccount){
            ((SavingsAccount)account).addInterest();
        }
        if (account.getBalance() != 90){
            return false;
        }

        return true;
    }
}
