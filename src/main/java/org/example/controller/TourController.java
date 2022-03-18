package org.example.controller;

import org.example.entities.*;
import org.example.services.CountrySevice;
import org.example.services.ProgramService;
import org.example.services.TourService;
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
    private TourService tourService;

    @Autowired
    private TourTypeService tourTypeService;

    @Autowired
    private CountrySevice countrySevice;

    @Autowired
    private ProgramService programService;

    @RequestMapping("/get-all")
    public String showAllTours(Model model){
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        return "tourTable";
    }

    @RequestMapping("/add")
    public String addNewTour(Model model){
        model.addAttribute("tourAdd", new Tour());
        return "tourAdd";
    }

    @RequestMapping("/save")
    public String saveTour(@ModelAttribute("tourAdd") Tour tour,
                           @RequestParam Integer tourTypeId,
                           @RequestParam Integer countryId,
                           @RequestParam Integer programNumber){
        TourType tourType = tourTypeService.getBy(tourTypeId);
        Country country = countrySevice.getBy(countryId);
        Program program = programService.getBy(programNumber);
        tour.setTourType(tourType);
        tour.setCountry(country);
        tour.setProgram(program);

        tourService.insert(tour);

        return "tourTable";
    }

    @RequestMapping("/type/get-all")
    public String showAllTourTypes(Model model){
        List<TourType> tourTypes = tourTypeService.getAll();
        model.addAttribute("tourTypes", tourTypes);
        return "tourTypeTable";
    }
}
