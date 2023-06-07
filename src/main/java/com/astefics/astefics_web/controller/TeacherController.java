package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.TeacherDAO;
import com.astefics.astefics_web.entity.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TeacherController {

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

    @GetMapping("/newTeacher")
    public String newTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/teacherForm";
    }

    @PostMapping("/newTeacher")
    public String saveNewTeacher(@ModelAttribute("teacher") Teacher teacher) {
        dao.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id") String id) {
        dao.deleteTeacher(Integer.parseInt(id));
        return "redirect:/teachers";
    }

    @GetMapping("/modifyTeacher/{id}")
    public String modifyTeacher(@PathVariable("id") String id, Model model) {
        Teacher teacher = dao.getOneTeacherById(Integer.parseInt(id));
        if (teacher != null) {
            model.addAttribute("teacher", teacher);
            return "teacher/modifyTeacher";
        } else {
            return "noRessource";
        }
    }

    @PostMapping("/modifyTeacher")
    public String saveModifiedTeacher(@ModelAttribute("teacher") Teacher teacher) {
        dao.addTeacher(teacher);
        return "redirect:/teachers";
    }
}
