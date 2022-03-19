package org.example.controller;

import org.example.entities.*;
import org.example.services.AviaClassService;
import org.example.services.AviaTicketService;
import org.example.services.TourFlightSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/aviaTicket")
public class AviaTicketController {
    @Autowired
    private AviaClassService aviaClassService;

    @Autowired
    private TourFlightSevice tourFlightSevice;

    @Autowired
    private AviaTicketService aviaTicketService;

    @RequestMapping("/add")
    public String addNewAviaTicket(Model model){
        model.addAttribute("aTicketAdd", new AviaTicket());
        List<AviaClass> aviaClasses = aviaClassService.getAll();
        model.addAttribute("avClasses", aviaClasses);
        List<TourFlight> tourFlights = tourFlightSevice.getAll();
        model.addAttribute("tFlights", tourFlights);
        return "aviaTicketAdd";
    }

    @RequestMapping("/save")
    public String saveNewAviaTicket(@ModelAttribute("aTicketAdd") AviaTicket aviaTicket, @RequestParam Integer aviaClassId, @RequestParam Integer flightCode){
        AviaClass aviaClass = aviaClassService.getBy(aviaClassId);
        if (aviaClass != null){
            aviaTicket.setAviaClass(aviaClass);
        }
        TourFlight tourFlight = tourFlightSevice.getBy(flightCode);
        if (tourFlight != null){
            aviaTicket.setTourFlight(tourFlight);
        }
        aviaTicketService.insert(aviaTicket);
        return "redirect:/aviaTicket/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllAviaTickets(Model model){
        List<AviaTicket> aviaTickets = aviaTicketService.getAll();
        model.addAttribute("aTickets", aviaTickets);
        return "aviaTicketTable";
    }

    @RequestMapping("/edit")
    public String editAviaTicket(Model model, @RequestParam(value = "ticketNumber") Integer aviaTicketCode){
        AviaTicket aviaTicket = aviaTicketService.getBy(aviaTicketCode);
        model.addAttribute("aTicketEdit", aviaTicket);
        List<AviaClass> aviaClasses = aviaClassService.getAll();
        model.addAttribute("avClasses", aviaClasses);
        List<TourFlight> tourFlights = tourFlightSevice.getAll();
        model.addAttribute("tFlights", tourFlights);
        return "aviaTicketEdit";
    }

    @RequestMapping("/update")
    public String updateAviaTicket(@ModelAttribute("aTicketEdit") AviaTicket aviaTicket, @RequestParam Integer aviaClassId, @RequestParam Integer flightCode){
        AviaClass aviaClass = aviaClassService.getBy(aviaClassId);
        if (aviaClass != null){
            aviaTicket.setAviaClass(aviaClass);
        }
        TourFlight tourFlight = tourFlightSevice.getBy(flightCode);
        if (tourFlight != null){
            aviaTicket.setTourFlight(tourFlight);
        }
        aviaTicketService.update(aviaTicket);
        return "redirect:/aviaTicket/get-all";
    }

    @RequestMapping("/delete/{aviaTicketCode}")
    public String deleteAviaTicket(@PathVariable(value = "aviaTicketCode") Integer aviaTicketCode){
        aviaTicketService.delete(aviaTicketCode);
        return "redirect:/aviaTicket/get-all";
    }
}
