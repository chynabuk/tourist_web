package org.example.controller;

import org.example.entities.Country;
import org.example.entities.Position;
import org.example.services.CountrySevice;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("country")
public class CountryController {
    @Autowired
    private CountrySevice countrySevice;

    @RequestMapping("/get-all")
    public String getAllCountry(Model model){
        List<Country> countries = countrySevice.getAll();
        model.addAttribute("allCon", countries);
        return "countryTable";
    }
}
