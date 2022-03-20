package org.example.controller;

import org.example.entities.Agreement;
import org.example.entities.Client;
import org.example.entities.Tour;
import org.example.services.AgreementService;
import org.example.services.ClientService;
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
@RequestMapping("/agreement")
public class AgreementController {
    @Autowired
    private AgreementService agreementService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/add")
    public String addNewAgreement(Model model){
        model.addAttribute("agreementAdd", new Agreement());
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        return "agreementAdd";
    }

    @RequestMapping("/save")
    public String saveNewAgreement(@ModelAttribute("agreementAdd") Agreement agreement,
                                   @RequestParam Integer clientNumber,
                                   @RequestParam Integer tourNumber){
        Client client = clientService.getBy(clientNumber);
        if (client != null){
            agreement.setClient(client);
        }
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            agreement.setTour(tour);
        }
        agreementService.insert(agreement);
        return "redirect:/agreement/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllAgreements(Model model){
        List<Agreement> agreements = agreementService.getAll();
        model.addAttribute("agreements", agreements);
        return "agreementTable";
    }

    @RequestMapping("/edit")
    public String editAgreement(Model model, @RequestParam(value = "agreementNumber") Integer agreementNumber){
        Agreement agreement = agreementService.getBy(agreementNumber);
        model.addAttribute("agreementEdit", agreement);
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        return "agreementEdit";
    }

    @RequestMapping("/update")
    public String updateAgreement(@ModelAttribute("agreementEdit") Agreement agreement,
                                  @RequestParam Integer clientNumber,
                                  @RequestParam Integer tourNumber){
        Client client = clientService.getBy(clientNumber);
        if (client != null){
            agreement.setClient(client);
        }
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            agreement.setTour(tour);
        }
        agreementService.update(agreement);
        return "redirect:/agreement/get-all";
    }

    @RequestMapping("/delete/{agreementNumber}")
    public String deleteAgreement(@PathVariable(value = "agreementNumber") Integer agreementNumber){
        agreementService.delete(agreementNumber);
        return "redirect:/agreement/get-all";
    }
}
