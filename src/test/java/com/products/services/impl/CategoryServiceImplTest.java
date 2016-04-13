package com.products.services.impl;

import com.products.entities.Category;
import com.products.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vladimir on 11.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test_app_context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCreate() {
        Category category = createCategory("Monitor", "Computer display");

        List<Category> lst = categoryService.list();
        categoryService.create(category);
        List<Category> lst2 = categoryService.list();

        assertEquals(lst.size() + 1, lst2.size());
    }

    private Category createCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return category;
    }

    @Test
    public void testList() {
        List<Category> lst2 = categoryService.list();
        int lstSize = lst2.size();

        Category category = createCategory("Monitor", "Computer display");
        Category category2 = createCategory("Monitor2", "Computer display");

        categoryService.create(category);
        categoryService.create(category2);

        assertEquals(lstSize + 2, categoryService.list().size());
    }

    @Test
    public  void testUpdate() {
        String newName = "Mobile phone";
        String newDescr = "Mobile phones";

        Category category = createCategory("Cell phone", "Cellular phone");
        categoryService.create(category);
        Long id = category.getId();

        category.setName(newName);
        category.setDescription(newDescr);

        categoryService.update(category);
        Category category2 = categoryService.getById(category.getId());
        assertEquals(newName, category2.getName());
        assertEquals(newDescr, category2.getDescription());
    }

    @Test
    public void testDelete() {
        Category categories[] = {createCategory("Monitor1", "Computer display"),
            createCategory("Monitor2", "Computer display"),
            createCategory("Monitor3", "Computer display"),
            createCategory("Monitor4", "Computer display"),
            createCategory("Monitor5", "Computer display")};

        for(Category category :categories) {
            categoryService.create(category);
        }

        categoryService.delete(categories[0]);
        Category cat1 = categoryService.getById(categories[0].getId());

        assertNull(cat1);
    }
}
