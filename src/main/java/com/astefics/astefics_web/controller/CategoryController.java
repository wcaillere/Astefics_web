package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDAO dao;

    @GetMapping("/categories")
    public String GetCategories(Model model) {
        model.addAttribute("categories", dao.getAllCategories());

        return "categories";
    }
}
