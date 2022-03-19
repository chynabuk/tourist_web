package org.example.controller;

import org.example.entities.Event;
import org.example.entities.TicketForEvent;
import org.example.entities.Tour;
import org.example.entities.TourFlight;
import org.example.services.EventService;
import org.example.services.TicketForEventService;
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
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/add")
    public String addNewEvent(Model model){
        model.addAttribute("eventAdd", new Event());
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);

        return "eventAdd";
    }

    @RequestMapping("/save")
    public String saveNewEvent(@ModelAttribute("eventAdd") Event event, @RequestParam Integer tourNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            event.setTour(tour);
        }
        eventService.insert(event);

        return "redirect:/event/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllEvents(Model model){
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "eventTable";
    }

    @RequestMapping("/edit")
    public String editEvent(Model model, @RequestParam(value = "eventId") Integer eventId){
        Event event = eventService.getBy(eventId);
        model.addAttribute("eventEdit", event);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);

        return "eventEdit";
    }

    @RequestMapping("/update")
    public String updateEvent(@ModelAttribute("eventEdit") Event event, @RequestParam Integer tourNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            event.setTour(tour);
        }
        eventService.update(event);

        return "redirect:/event/get-all";
    }

    @RequestMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable(value = "eventId") Integer eventId){
        eventService.delete(eventId);
        return "redirect:/event/get-all";
    }

}
