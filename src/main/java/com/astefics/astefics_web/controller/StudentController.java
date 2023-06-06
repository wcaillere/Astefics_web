package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.StudentDAO;
import com.astefics.astefics_web.DAO.TeacherDAO;
import com.astefics.astefics_web.entity.Student;
import com.astefics.astefics_web.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO dao;

    @GetMapping("/students")
    public String getTeachers(Model model) {
        model.addAttribute("students", dao.getAllStudents());
        return "student/students";
    }


    @GetMapping("/student/{id}")
    public String studentDetails(@PathVariable("id") String id, Model model) {
        Student student = dao.getOneStudentById(Integer.parseInt(id));

        if (student != null) {
            model.addAttribute("student", student);
            return "student/studentDetails";
        } else {
            return "noRessource";
        }
    }


    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/studentForm";
    }

    @PostMapping("/newStudent")
    public String saveNewStudent(@ModelAttribute("student") Student student) {
        dao.addStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        dao.deleteStudent(Integer.parseInt(id));
        return "redirect:/students";
    }

    @GetMapping("/modifyStudent/{id}")
    public String modifyTeacher(@PathVariable("id") String id, Model model) {
        Student student = dao.getOneStudentById(Integer.parseInt(id));
        if (student != null) {
            model.addAttribute("student", student);
            return "student/modifyStudent";
        } else {
            return "noRessource";
        }
    }

    @PostMapping("/modifyStudent")
    public String saveModifiedTeacher(@ModelAttribute("student") Student student) {
        dao.addStudent(student);
        return "redirect:/students";
    }
}
