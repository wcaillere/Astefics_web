package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.TeacherDAO;
import com.astefics.astefics_web.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TeacherController {

    @Autowired
    private TeacherDAO dao;

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        model.addAttribute("teachers", dao.getAllTeachers());
        return "teacher/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String teacherDetails(@PathVariable("id") String id, Model model) {
        Teacher teacher = dao.getOneTeacherById(Integer.parseInt(id));

        if (teacher != null) {
            model.addAttribute("teacher", teacher);
            return "teacher/teacherDetails";
        } else {
            return "noRessource";
        }
    }
}
