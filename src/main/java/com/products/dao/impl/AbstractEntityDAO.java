package com.products.dao.impl;

import com.products.dao.EntityDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vladimir on 12.04.2016.
 */
public abstract class AbstractEntityDAO<T> implements EntityDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getEntityClass();

    @Override
    public void save(final T e) {
        getSession().save(e);
    }

    @Override
    public void update(final T e) {
        getSession().update(e);
    }

    @Override
    public void delete(final T e) {
        getSession().delete(e);
    }

    @Override
    public void remove(final T e) {
        delete(e);
    }

    @Override
    public T findById(final Serializable id) {
        return (T) getSession().get(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(getEntityClass()).list();
    }
}
