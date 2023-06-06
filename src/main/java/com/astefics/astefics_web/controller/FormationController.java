package com.astefics.astefics_web.controller;

import com.astefics.astefics_web.DAO.FormationDAO;
import com.astefics.astefics_web.entity.Formation;
import com.astefics.astefics_web.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FormationController {

    @Autowired
    private FormationDAO dao;

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

            StringBuilder students = new StringBuilder();
            for (Student student : formation.getStudents()) {
                students.append(student.getFirstname()).append(" ").append(student.getLastname()).append("\n");
            }
            students.setLength(students.length() - 1);

            model.addAttribute("students", students);

            return "formation/formationDetails";
        } else {
            return "noRessource";
        }
    }
}
