package org.academiadecodigo.javabank.managers;

public interface TransactionManager {

    public void beginRead();

    public void beginWrite();

    public void commit();

    public void rollback();


}
