package org.example.controller;

import org.example.entities.HotelNumber;
import org.example.entities.HotelNumberPermit;
import org.example.entities.Permit;
import org.example.services.HotelNumberPermitService;
import org.example.services.HotelNumberService;
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
@RequestMapping("/hotelNumberPermit")
public class HotelNumberPermitController {
    @Autowired
    private HotelNumberPermitService hotelNumberPermitService;

    @Autowired
    private HotelNumberService hotelNumberService;

    @Autowired
    private PermitService permitService;

    @RequestMapping("/add")
    public String addNewHotelNumberPermit(Model model){
        model.addAttribute("hotelNumberPermitAdd", new HotelNumberPermit());
        List<HotelNumber> hotelNumbers = hotelNumberService.getAll();
        model.addAttribute("hotelNumbers", hotelNumbers);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "hotelNumberPermitAdd";
    }

    @RequestMapping("/save")
    public String saveNewHotelNumberPermit(@ModelAttribute("hotelNumberPermitAdd") HotelNumberPermit hotelNumberPermit,
                                   @RequestParam Integer hotelNumberCode,
                                   @RequestParam Integer permitNumber){
        HotelNumber hotelNumber = hotelNumberService.getBy(hotelNumberCode);
        if (hotelNumber != null){
            hotelNumberPermit.setHotelNumber(hotelNumber);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            hotelNumberPermit.setPermit(permit);
        }
        hotelNumberPermitService.insert(hotelNumberPermit);
        return "redirect:/hotelNumberPermit/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllhotelNumberPermits(Model model){
        List<HotelNumberPermit> hotelNumberPermits = hotelNumberPermitService.getAll();
        model.addAttribute("hotelNumberPermits", hotelNumberPermits);
        return "hotelNumberPermitTable";
    }

    @RequestMapping("/edit")
    public String editHotelNumberPermit(Model model, @RequestParam(value = "hotelNumberPermitCode") Integer hotelNumberPermitCode){
        HotelNumberPermit hotelNumberPermit = hotelNumberPermitService.getBy(hotelNumberPermitCode);
        model.addAttribute("hotelNumberPermitEdit", hotelNumberPermit);
        List<HotelNumber> hotelNumbers = hotelNumberService.getAll();
        model.addAttribute("hotelNumbers", hotelNumbers);
        List<Permit> permits = permitService.getAll();
        model.addAttribute("permits", permits);
        return "hotelNumberPermitEdit";
    }

    @RequestMapping("/update")
    public String updateHotelNumberPermit(@ModelAttribute("hotelNumberPermitEdit") HotelNumberPermit hotelNumberPermit,
                                  @RequestParam Integer hotelNumberCode,
                                  @RequestParam Integer permitNumber){
        HotelNumber hotelNumber = hotelNumberService.getBy(hotelNumberCode);
        if (hotelNumber != null){
            hotelNumberPermit.setHotelNumber(hotelNumber);
        }
        Permit permit = permitService.getBy(permitNumber);
        if (permit != null){
            hotelNumberPermit.setPermit(permit);
        }
        hotelNumberPermitService.update(hotelNumberPermit);
        return "redirect:/hotelNumberPermit/get-all";
    }

    @RequestMapping("/delete/{hotelNumberPermitCode}")
    public String deleteHotelNumberPermit(@PathVariable(value = "hotelNumberPermitCode") Integer hotelNumberPermitCode){
        hotelNumberPermitService.delete(hotelNumberPermitCode);
        return "redirect:/hotelNumberPermit/get-all";
    }
}
