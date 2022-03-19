package org.example.controller;

import org.example.entities.Tour;
import org.example.entities.TourFlight;
import org.example.services.TourFlightSevice;
import org.example.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tourFlight")
public class TourFlightController {
    @Autowired
    private TourFlightSevice tourFlightSevice;

    @Autowired
    private TourService tourService;

    @RequestMapping("/add")
    public String addNewTourFlight(Model model){
        model.addAttribute("tFlightAdd", new TourFlight());
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);

        return "tourFlightAdd";
    }

    @RequestMapping("/save")
    public String saveNewTourFlight(@ModelAttribute("tFlightAdd") TourFlight tourFlight, @RequestParam Integer tourNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            tourFlight.setTour(tour);
        }
        tourFlightSevice.insert(tourFlight);

        return "redirect:/tourFlight/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllTourFlights(Model model){
        List<TourFlight> tourFlights = tourFlightSevice.getAll();
        model.addAttribute("allTFlights", tourFlights);
        return "tourFlightTable";
    }

    @RequestMapping("/edit")
    public String editTourFlight(Model model, @RequestParam(value = "flightCode") Integer flightCode){
        TourFlight tourFlight = tourFlightSevice.getBy(flightCode);
        model.addAttribute("tFlightEdit", tourFlight);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);

        return "tourFlightEdit";
    }

    @RequestMapping("/update")
    public String updateTourFlight(@ModelAttribute("tFlightEdit") TourFlight tourFlight, @RequestParam Integer tourNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            tourFlight.setTour(tour);
        }
        tourFlightSevice.update(tourFlight);

        return "redirect:/tourFlight/get-all";
    }

    @RequestMapping("/delete/{flightCode}")
    public String deleteTourFlight(@PathVariable(value = "flightCode") Integer flightCode){
        tourFlightSevice.delete(flightCode);
        return "redirect:/tourFlight/get-all";
    }
}
