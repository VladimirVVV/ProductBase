package com.products.services;

import com.products.entities.Category;

import java.util.List;

/**
 * Created by vladimir on 09.04.2016.
 */
public interface CategoryService {
    void create(Category category);

    List<Category> list();
}
