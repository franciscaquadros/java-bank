package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.AbstractModel;

import java.util.List;

public interface genericDao<T extends AbstractModel> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}
