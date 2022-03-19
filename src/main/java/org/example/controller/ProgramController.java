package org.example.controller;

import org.example.entities.Program;
import org.example.entities.Tour;
import org.example.entities.TourFlight;
import org.example.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @RequestMapping("/add")
    public String addNewProgram(Model model){
        model.addAttribute("progAdd", new Program());
        return "programAdd";
    }

    @RequestMapping("/save")
    public String saveNewProgram(@ModelAttribute("progAdd")Program program){
        programService.insert(program);
        return "redirect:/program/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllPrograms(Model model){
        List<Program> programs = programService.getAll();
        model.addAttribute("programs", programs);
        return "programTable";
    }

    @RequestMapping("/edit")
    public String editProgram(Model model, @RequestParam(value = "programNumber") Integer programNumber){
        Program program = programService.getBy(programNumber);
        model.addAttribute("progEdit", program);
        return "programEdit";
    }

    @RequestMapping("/update")
    public String updateProgram(@ModelAttribute("progEdit") Program program){
        programService.update(program);
        return "redirect:/program/get-all";
    }

    @RequestMapping("/delete/{programNumber}")
    public String deleteProgram(@PathVariable(value = "programNumber") Integer programNumber){
        programService.delete(programNumber);
        return "redirect:/program/get-all";
    }
}
