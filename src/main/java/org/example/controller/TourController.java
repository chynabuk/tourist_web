package org.example.controller;

import org.example.entities.*;
import org.example.services.CountrySevice;
import org.example.services.ProgramService;
import org.example.services.TourService;
import org.example.services.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<TourType> tourTypes = tourTypeService.getAll();
        model.addAttribute("tourTypes", tourTypes);
        List<Country> countries = countrySevice.getAll();
        model.addAttribute("countries", countries);
        List<Program> programs = programService.getAll();
        model.addAttribute("programs", programs);
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

        return "redirect:/tour/get-all";
    }

    @RequestMapping("/edit")
    public String editTour(Model model, @RequestParam(value = "tourNumber") Integer tourNumber){
        Tour tour = tourService.getBy(tourNumber);
        model.addAttribute("tourEdit", tour);
        List<TourType> tourTypes = tourTypeService.getAll();
        model.addAttribute("tourTypes", tourTypes);
        List<Country> countries = countrySevice.getAll();
        model.addAttribute("countries", countries);
        List<Program> programs = programService.getAll();
        model.addAttribute("programs", programs);
        return "tourEdit";
    }

    @RequestMapping("/update")
    public String updateTour(@ModelAttribute("tourEdit") Tour tour,
                             @RequestParam Integer tourTypeId,
                             @RequestParam Integer countryId,
                             @RequestParam Integer programNumber){
        if (tourTypeId != null){
            TourType tourType = tourTypeService.getBy(tourTypeId);
            tour.setTourType(tourType);
        }
        if (countryId != null){
            Country country = countrySevice.getBy(countryId);
            tour.setCountry(country);
        }
        if (programNumber != null){
            Program program = programService.getBy(programNumber);
            tour.setProgram(program);
        }

        tourService.update(tour);

        return "redirect:/tour/get-all";
    }

    @RequestMapping("/delete/{tourNumber}")
    public String deleteTour(@PathVariable(value = "tourNumber") Integer tourNumber){
        tourService.delete(tourNumber);
        return "redirect:/tour/get-all";
    }

    @RequestMapping("/type/get-all")
    public String showAllTourTypes(Model model){
        List<TourType> tourTypes = tourTypeService.getAll();
        model.addAttribute("tourTypes", tourTypes);
        return "tourTypeTable";
    }
}
