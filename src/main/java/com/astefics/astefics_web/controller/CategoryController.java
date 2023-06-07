package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.CategoryDAO;
import com.astefics.astefics_web.entity.Category;
import com.astefics.astefics_web.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CategoryController {

    private CategoryDAO dao;

    @GetMapping("/categories")
    public String GetCategories(Model model) {
        model.addAttribute("categories", dao.getAllCategories());
        model.addAttribute("category", new Category());

        return "category/categories";
    }

    @GetMapping("/category/{id}")
    public String categoryDetails(@PathVariable("id") String id, Model model) {
        Category category = dao.getOneCategoryById(Integer.parseInt(id));

        if (category != null) {
            model.addAttribute("category", category);
            return "category/categoryDetails";
        } else {
            return "noRessource";
        }
    }

    @PostMapping("/addCategory")
    public String AddCategory(@ModelAttribute("category") Category category) {
        dao.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") String id) {
        dao.deleteCategory(Integer.parseInt(id));
        return "redirect:/categories";
    }

    @GetMapping({"/modifyCategory/{id}/{newName}", "/modifyCategory/{id}/"})
    public String deleteCategory(@PathVariable("id") String id, @PathVariable(value = "newName", required = false) String newName) {
        if (newName != null) {
            dao.modifyCategory(Integer.parseInt(id), newName);
        }
        return "redirect:/categories";
    }
}
