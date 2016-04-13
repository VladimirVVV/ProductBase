package com.products.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vladimir on 12.04.2016.
 */
public interface EntityDAO<T> {

    void save(T e);

    void update(T e);

    void delete(T e);

    void remove(T e);

    T findById(Serializable id);

    List<T> findAll();
}