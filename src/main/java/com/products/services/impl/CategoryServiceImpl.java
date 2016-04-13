package com.products.services.impl;

import com.products.dao.CategoryDAO;
import com.products.entities.Category;
import com.products.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 11.04.2016.
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public void create(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public List<Category> list() {
        return categoryDAO.findAll();
    }

}
