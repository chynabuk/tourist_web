package org.example.controller;

import org.example.entities.Agreement;
import org.example.entities.Permit;
import org.example.entities.Tourist;
import org.example.services.AgreementService;
import org.example.services.PermitService;
import org.example.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permit")
public class PermitController {
    @Autowired
    private PermitService permitService;

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private TouristService touristService;

    @RequestMapping("/add")
    public String addNewPermit(Model model){
        model.addAttribute("permitAdd", new Permit());
        List<Agreement> agreements = agreementService.getAll();
        model.addAttribute("agreements", agreements);
        List<Tourist> tourists = touristService.getAll();
        model.addAttribute("tourists", tourists);
        return "permitAdd";
    }

    @RequestMapping("/save")
    public String saveNewPermit(@ModelAttribute("permitAdd") Permit permit,
                                   @RequestParam Integer agreementNumber,
                                   @RequestParam Integer passportNumber){
        Agreement agreement = agreementService.getBy(agreementNumber);
        if (agreement != null){
            permit.setAgreement(agreement);
        }
        Tourist tourist = touristService.getBy(passportNumber);
        if (tourist != null){
            permit.setTourist(tourist);
        }
        permitService.insert(permit);
        return "redirect:/permit/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllPermits(Model model){
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "permitTable";
    }

    @RequestMapping("/edit")
    public String editPermit(Model model, @RequestParam(value = "permitNumber") Integer permitNumber){
        Permit permit = permitService.getBy(permitNumber);
        model.addAttribute("permitEdit", permit);
        List<Agreement> agreements = agreementService.getAll();
        model.addAttribute("agreements", agreements);
        List<Tourist> tourists = touristService.getAll();
        model.addAttribute("tourists", tourists);
        return "permitEdit";
    }

    @RequestMapping("/update")
    public String updatePermit(@ModelAttribute("permitEdit") Permit permit,
                                  @RequestParam Integer agreementNumber,
                                  @RequestParam Integer passportNumber){
        Agreement agreement = agreementService.getBy(agreementNumber);
        if (agreement != null){
            permit.setAgreement(agreement);
        }
        Tourist tourist = touristService.getBy(passportNumber);
        if (tourist != null){
            permit.setTourist(tourist);
        }
        permitService.update(permit);
        return "redirect:/permit/get-all";
    }

    @RequestMapping("/delete/{permitNumber}")
    public String deletePermit(@PathVariable(value = "permitNumber") Integer permitNumber){
        permitService.delete(permitNumber);
        return "redirect:/permit/get-all";
    }
}
