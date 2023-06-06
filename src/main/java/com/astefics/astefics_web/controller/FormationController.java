package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.*;
import com.astefics.astefics_web.entity.Formation;
import com.astefics.astefics_web.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormationController {

    @Autowired
    private FormationDAO dao;

    @Autowired
    private LevelDAO levelDao;

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private StudentDAO studentDao;

    @GetMapping("/formations")
    public String GetFormations(Model model) {
        model.addAttribute("formations", dao.getAllFormations());
        return "formation/formations";
    }

    @GetMapping("/formation/{id}")
    public String formationDetails(@PathVariable("id") String id, Model model) {
        Formation formation = dao.getOneFormationById(Integer.parseInt(id));

        if (formation != null) {
            model.addAttribute("formation", formation);

            if (formation.getStudents().size() != 0) {
                StringBuilder students = new StringBuilder();
                for (Student student : formation.getStudents()) {
                    students.append(student.getFirstname()).append(" ").append(student.getLastname()).append("\n");
                }
                students.setLength(students.length() - 1);

                model.addAttribute("students", students);
            } else {
                model.addAttribute("students", "pas de stagiaires inscrits pour l'instant.");
            }

            return "formation/formationDetails";
        } else {
            return "noRessource";
        }
    }

    @GetMapping("/newFormation")
    public String newFormation(Model model) {
        model.addAttribute("formation", new Formation());
        model.addAttribute("levels", levelDao.getAllLevels());
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("teachers", teacherDAO.getAllTeachers());
        model.addAttribute("students", studentDao.getAllStudents());
        return "formation/formationForm";
    }

    @PostMapping("/newFormation")
    public String saveNewFormation(@ModelAttribute("formation") Formation formation) {

        dao.addFormation(formation);
        return "redirect:/formations";
    }

    @GetMapping("/deleteFormation/{id}")
    public String deleteFormation(@PathVariable("id") String id) {
        dao.deleteFormation(Integer.parseInt(id));
        return "redirect:/formations";
    }
}
