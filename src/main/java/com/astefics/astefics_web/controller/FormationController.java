package com.astefics.astefics_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormationController {

    @GetMapping("/formations")
    public String GetFormations() {
        return "formation/formations";
    }
}
