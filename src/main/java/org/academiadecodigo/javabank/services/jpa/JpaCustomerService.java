package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.managers.JpaTransactionManager;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerService extends AbstractJpaService<Customer> implements CustomerService {

    public JpaCustomerService(EntityManagerFactory emf) {
        super(emf, Customer.class);
    }

    private CustomerDao customerDao;
    private JpaTransactionManager transactionManager;

    @Override
    public double getBalance(Integer id) {

        try {

            transactionManager.beginRead();
            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            double balance = 0;
            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } catch (TransactionException ex){
            transactionManager.rollback();
        }
        return -1;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        try {

            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            Set<Integer> accountIds = new HashSet<>();

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;

        } catch (TransactionException ex){
            transactionManager.rollback();
        }

        return null;

    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setTransactionManager(JpaTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
