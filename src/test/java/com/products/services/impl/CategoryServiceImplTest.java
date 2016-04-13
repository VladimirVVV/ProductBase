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

/**
 * Created by vladimir on 11.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ServiceTestConfig.class})
//@ComponentScan(basePackages = {"com.products.services.impl", "com.products.dao.impl"})
@ContextConfiguration(locations = {"classpath:META-INF/spring/test_app_context.xml"})
@TransactionConfiguration(defaultRollback=true,transactionManager="txManager")
//@ActiveProfiles("testProfile")
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCreate() {
        Category category = new Category();
        category.setName("Monitor");
        category.setDescription("Computer display");


        List<Category> lst = categoryService.list();
        categoryService.create(category);
        List<Category> lst2 = categoryService.list();

        assertEquals(lst.size() + 1, lst2.size());
    }

    @Test
    public void testList () {
        List<Category> lst2 = categoryService.list();
        int lstSize = lst2.size();

        Category category = new Category();
        category.setName("Monitor");
        category.setDescription("Computer display");

        Category category2 = new Category();
        category2.setName("Monitor2");
        category2.setDescription("Computer display");

        categoryService.create(category);
        categoryService.create(category2);

        assertEquals(lstSize + 2, categoryService.list().size());
    }
}
