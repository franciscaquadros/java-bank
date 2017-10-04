package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.AccountType;
import org.academiadecodigo.javabank.domain.CheckingAccount;

public class CheckingAccountTest {

    public boolean test() {

        Account account = new CheckingAccount(1, 15);

        // account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from account
        account.debit(40);
        if (account.getBalance() != 40) {
            return  false;
        }

        //the type of the account must be CHECKING
        if (account.getAccountType() != AccountType.CHECKING){
            return false;
        }

        if (account instanceof CheckingAccount){
            ((CheckingAccount)account).deductFee();
        }
        //it should be possible to deduct the fee
        //((CheckingAccount)account).deductFee();
        if (account.getBalance() != 25){
            return false;
        }

        return true;
    }

}
