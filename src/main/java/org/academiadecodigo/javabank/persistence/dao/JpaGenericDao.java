package org.academiadecodigo.javabank.persistence.dao;
import org.academiadecodigo.javabank.managers.JpaSessionManager;
import org.academiadecodigo.javabank.model.AbstractModel;

import java.util.List;

public abstract class JpaGenericDao<T extends AbstractModel> implements GenericDao<T>{

    private JpaSessionManager sessionManager;
    private Class<T> tClass;

    public JpaGenericDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public List<T> findAll(){
        return sessionManager.getCurrentSession().createQuery("from " + tClass.getSimpleName()).getResultList();

    }

    public T findById(Integer id){

        return sessionManager.getCurrentSession().find(tClass, id);

    }

    public T saveOrUpdate(T modelObject){

        return sessionManager.getCurrentSession().merge(modelObject);

    }

    public void delete(T object){

        sessionManager.getCurrentSession().remove(object);

    }

    public void setSessionManager(JpaSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
