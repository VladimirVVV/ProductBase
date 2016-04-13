package com.products.dao.impl;

import com.products.dao.CategoryDAO;
import com.products.entities.Category;
import org.springframework.stereotype.Service;

/**
 * Created by vladimir on 12.04.2016.
 */
@Service
public class CategoryDAOImpl extends AbstractEntityDAO<Category> implements CategoryDAO {
    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
