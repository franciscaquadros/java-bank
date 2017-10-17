package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.managers.JpaTransactionManager;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.JpaAccountDao;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class JpaAccountService extends AbstractJpaService<Account> implements AccountService {

    private AccountDao accountDao;
    private JpaTransactionManager transactionManager;

    public JpaAccountService(EntityManagerFactory emf){
        super(emf, Account.class);
    }

    @Override
    public void deposit(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDao.findById(id);

            if (account == null) {
                transactionManager.rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.credit(amount);
            accountDao.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }

    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDao.findById(id);

            if (account == null) {
                transactionManager.rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);
            accountDao.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        try {

            transactionManager.beginWrite();

            Account srcAccount = accountDao.findById(srcId);
            Account dstAccount = accountDao.findById(dstId);

            if (srcAccount == null || dstAccount == null) {
                transactionManager.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

            accountDao.saveOrUpdate(srcAccount);
            accountDao.saveOrUpdate(dstAccount);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }
    }

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(JpaTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
