package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    @Autowired
    private TeacherDAO dao;

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        model.addAttribute("teachers", dao.getAllTeachers());
        return "teacher/teachers";
    }
}
