package org.example.controller;

import org.example.entities.Employee;
import org.example.entities.Position;
import org.example.entities.TourType;
import org.example.services.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController {
    @Autowired
    private TourTypeService tourTypeService;

    @RequestMapping("/type/get-all")
    public String showAllTourTypes(Model model){
        List<TourType> tourTypes = tourTypeService.getAll();
        model.addAttribute("tourTypes", tourTypes);
        return "tourTypeTable";
    }
}
