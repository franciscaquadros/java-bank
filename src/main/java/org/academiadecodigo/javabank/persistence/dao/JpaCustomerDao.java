package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao{
    public JpaCustomerDao(Class aClass) {
        super(aClass);
    }

}
