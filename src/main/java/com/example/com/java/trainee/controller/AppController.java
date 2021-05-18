package com.example.com.java.trainee.controller;

import com.example.com.java.trainee.entity.Product;
import com.example.com.java.trainee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
public class AppController {
    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }
}
