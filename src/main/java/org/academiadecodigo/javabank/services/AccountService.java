package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;

public interface AccountService extends genericDao<Account> {

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

}
