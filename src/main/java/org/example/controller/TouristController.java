package org.example.controller;

import org.example.entities.Tourist;
import org.example.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tourist")
public class TouristController {
    @Autowired
    private TouristService touristService;

    @RequestMapping("/get-all")
    public String showAll(Model model){
        List<Tourist> tourists = touristService.getAll();
        model.addAttribute("tourists", tourists);
        return "touristTable";
    }

    @RequestMapping("/add")
    public String addNew(Model model){
        model.addAttribute("touristAdd", new Tourist());
        return "touristSaveForm";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("touristAdd") Tourist tourist){
        touristService.insert(tourist);
        return "redirect:/tourist/get-all";
    }

    @RequestMapping("/edit")
    public String editTourist(Model model, @RequestParam(value = "passportNumber") Integer passportNumber){
        Tourist tourist = touristService.getBy(passportNumber);
        model.addAttribute("touristEdit", tourist);

        return "touristEditForm";
    }

    @RequestMapping("/update")
    public String updateTourist(@ModelAttribute("touristEdit") Tourist tourist){
        touristService.update(tourist);

        return "redirect:/tourist/get-all";
    }

    @RequestMapping("/delete/{passportNumber}")
    public String deleteTourist(@PathVariable(value = "passportNumber") Integer passportNumber){
        touristService.delete(passportNumber);
        return "redirect:/tourist/get-all";
    }
}
