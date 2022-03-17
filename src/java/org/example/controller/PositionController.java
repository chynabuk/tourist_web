package org.example.controller;

import org.example.entities.Employee;
import org.example.entities.Position;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/get-all")
    public String getAllPosition(Model model){
        List<Position> positions = positionService.getAll();
        positions.forEach(p -> System.out.println(p.getPositionType().toString()));
        model.addAttribute("allPos", positions);
        return "positionTable";
    }
}
