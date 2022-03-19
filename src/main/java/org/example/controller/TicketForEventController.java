package org.example.controller;

import org.example.entities.Event;
import org.example.entities.TicketForEvent;
import org.example.services.EventService;
import org.example.services.TicketForEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/eventTicket")
public class TicketForEventController {
    @Autowired
    private TicketForEventService ticketForEventService;

    @Autowired
    private EventService eventService;

    @RequestMapping("/add")
    public String addNewEventTicket(Model model){
        model.addAttribute("eTicketAdd", new TicketForEvent());
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "eventTicketAdd";
    }

    @RequestMapping("/save")
    public String saveNewEventTicket(@ModelAttribute("eTicketAdd") TicketForEvent ticketForEvent, @RequestParam Integer eventId){
        Event event = eventService.getBy(eventId);
        if (event != null){
            ticketForEvent.setEvent(event);
        }
        ticketForEventService.insert(ticketForEvent);
        return "redirect:/eventTicket/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllEventTickets(Model model){
        List<TicketForEvent> ticketForEvents = ticketForEventService.getAll();
        model.addAttribute("eTickets", ticketForEvents);
        return "eventTicketTable";
    }

    @RequestMapping("/edit")
    public String editEventTicket(Model model, @RequestParam(value = "ticketNumber") Integer ticketNumber){
        TicketForEvent ticketForEvent = ticketForEventService.getBy(ticketNumber);
        model.addAttribute("eTicketEdit", ticketForEvent);
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "eventTicketEdit";
    }

    @RequestMapping("/update")
    public String updateEventTicket(@ModelAttribute("eTicketEdit") TicketForEvent ticketForEvent, @RequestParam Integer eventId){
        Event event = eventService.getBy(eventId);
        if (event != null){
            ticketForEvent.setEvent(event);
        }
        ticketForEventService.insert(ticketForEvent);
        return "redirect:/eventTicket/get-all";
    }

    @RequestMapping("/delete/{ticketNumber}")
    public String deleteEventTicket(@PathVariable(value = "ticketNumber") Integer ticketNumber){
        ticketForEventService.delete(ticketNumber);
        return "redirect:/eventTicket/get-all";
    }
}
