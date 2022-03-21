package org.example.controller;

import org.example.entities.AviaTicket;
import org.example.entities.AviaTicketPermit;
import org.example.entities.Permit;
import org.example.services.AviaTicketPermitService;
import org.example.services.AviaTicketService;
import org.example.services.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/aviaTicketPermit")
public class AviaTicketPermitController {
    @Autowired
    private AviaTicketPermitService aviaTicketPermitService;

    @Autowired
    private AviaTicketService aviaTicketService;

    @Autowired
    private PermitService permitService;

    @RequestMapping("/add")
    public String addNewAviaTicketPermit(Model model){
        model.addAttribute("aviaTicketPermitAdd", new AviaTicketPermit());
        List<AviaTicket> aviaTickets = aviaTicketService.getAll();
        model.addAttribute("aviaTickets", aviaTickets);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "aviaTicketPermitAdd";
    }

    @RequestMapping("/save")
    public String saveNewAviaTicketPermit(@ModelAttribute("aviaTicketPermitAdd") AviaTicketPermit aviaTicketPermit,
                                      @RequestParam Integer aviaTicketCode,
                                      @RequestParam Integer permitNumber){
        AviaTicket aviaTicket = aviaTicketService.getBy(aviaTicketCode);
        if (aviaTicket != null){
            aviaTicketPermit.setAviaTicket(aviaTicket);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            aviaTicketPermit.setPermit(permit);
        }
        aviaTicketPermitService.insert(aviaTicketPermit);
        return "redirect:/aviaTicketPermit/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllAviaTicketPermits(Model model){
        List<AviaTicketPermit> aviaTicketPermits = aviaTicketPermitService.getAll();
        model.addAttribute("avitTicketPermits", aviaTicketPermits);
        return "aviaTicketPermitTable";
    }

    @RequestMapping("/edit")
    public String editAviaTicketPermit(Model model, @RequestParam(value = "aviaTickedPermitCode") Integer aviaTickedPermitCode){
        AviaTicketPermit aviaTicketPermit = aviaTicketPermitService.getBy(aviaTickedPermitCode);
        model.addAttribute("aviaTicketPermitEdit", aviaTicketPermit);
        List<AviaTicket> aviaTickets = aviaTicketService.getAll();
        model.addAttribute("aviaTickets", aviaTickets);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "aviaTicketPermitEdit";
    }

    @RequestMapping("/update")
    public String updateAviaTicketPermit(@ModelAttribute("aviaTicketPermitEdit") AviaTicketPermit aviaTicketPermit,
                                     @RequestParam Integer aviaTicketCode,
                                     @RequestParam Integer permitNumber){
        AviaTicket aviaTicket = aviaTicketService.getBy(aviaTicketCode);
        if (aviaTicket != null){
            aviaTicketPermit.setAviaTicket(aviaTicket);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            aviaTicketPermit.setPermit(permit);
        }
        aviaTicketPermitService.update(aviaTicketPermit);
        return "redirect:/aviaTicketPermit/get-all";
    }

    @RequestMapping("/delete/{aviaTickedPermitCode}")
    public String deleteAgreement(@PathVariable(value = "aviaTickedPermitCode") Integer aviaTickedPermitCode){
        aviaTicketPermitService.delete(aviaTickedPermitCode);
        return "redirect:/aviaTicketPermit/get-all";
    }
}
