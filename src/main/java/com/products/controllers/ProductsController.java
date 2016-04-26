package com.products.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vladimir on 06.04.2016.
 */
@Controller
public class ProductsController {
    final Logger logger = LoggerFactory.getLogger(ProductsController.class);
//
    @RequestMapping("/")
    public String redirectToProducts() {
        System.out.println("fhgfgvhfgh");
        return "redirect:/products";
    }

    @RequestMapping("/products")
    public String showProducts(Model model) {
        logger.info("Controller started !!!!!!!!!!!!!!");
        model.addAttribute("greeting", "Hello world!!!!");

        return "products";
    }


}
