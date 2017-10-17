package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.account.Account;

public class JpaAccountDao extends JpaGenericDao<Account> implements AccountDao{

    public JpaAccountDao(Class aClass) {
        super(aClass);
    }

}
