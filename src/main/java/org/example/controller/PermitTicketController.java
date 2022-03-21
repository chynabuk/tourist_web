package org.example.controller;

import org.example.entities.Permit;
import org.example.entities.PermitTicket;
import org.example.entities.TicketForEvent;
import org.example.services.PermitService;
import org.example.services.PermitTicketService;
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
@RequestMapping("/permitTicket")
public class PermitTicketController {
    @Autowired
    private PermitTicketService permitTicketService;

    @Autowired
    private TicketForEventService ticketForEventService;

    @Autowired
    private PermitService permitService;

    @RequestMapping("/add")
    public String addNewPermitTicket(Model model){
        model.addAttribute("permitTicketAdd", new PermitTicket());
        List<TicketForEvent> ticketForEvents = ticketForEventService.getAll();
        model.addAttribute("ticketForEvents", ticketForEvents);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "permitTicketAdd";
    }

    @RequestMapping("/save")
    public String saveNewPermitTicket(@ModelAttribute("permitTicketAdd") PermitTicket permitTicket,
                                   @RequestParam Integer ticketNumber,
                                   @RequestParam Integer permitNumber){
        TicketForEvent ticketForEvent = ticketForEventService.getBy(ticketNumber);
        if (ticketForEvent != null){
            permitTicket.setTicketForEvent(ticketForEvent);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            permitTicket.setPermit(permit);
        }
        permitTicketService.insert(permitTicket);
        return "redirect:/permitTicket/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllPermitTickets(Model model){
        List<PermitTicket> permitTickets = permitTicketService.getAll();
        model.addAttribute("permitTickets", permitTickets);
        return "permitTicketTable";
    }

    @RequestMapping("/edit")
    public String editPermitTicket(Model model, @RequestParam(value = "permitTicketNumber") Integer permitTicketNumber){
        PermitTicket permitTicket = permitTicketService.getBy(permitTicketNumber);
        model.addAttribute("permitTicketEdit", permitTicket);
        List<TicketForEvent> ticketForEvents = ticketForEventService.getAll();
        model.addAttribute("ticketForEvents", ticketForEvents);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "permitTicketEdit";
    }

    @RequestMapping("/update")
    public String updatePermitTicket(@ModelAttribute("permitTicketEdit") PermitTicket permitTicket,
                                  @RequestParam Integer ticketNumber,
                                  @RequestParam Integer permitNumber){
        TicketForEvent ticketForEvent = ticketForEventService.getBy(ticketNumber);
        if (ticketForEvent != null){
            permitTicket.setTicketForEvent(ticketForEvent);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            permitTicket.setPermit(permit);
        }
        permitTicketService.update(permitTicket);
        return "redirect:/permitTicket/get-all";
    }

    @RequestMapping("/delete/{permitTicketNumber}")
    public String deleteAgreement(@PathVariable(value = "permitTicketNumber") Integer permitTicketNumber){
        permitTicketService.delete(permitTicketNumber);
        return "redirect:/permitTicket/get-all";
    }
}
