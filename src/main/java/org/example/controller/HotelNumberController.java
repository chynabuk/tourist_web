package org.example.controller;

import org.example.entities.Hotel;
import org.example.entities.HotelNumber;
import org.example.entities.HotelNumberCategory;
import org.example.services.HotelNumberCategoryService;
import org.example.services.HotelNumberService;
import org.example.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hotelNumber")
public class HotelNumberController {
    @Autowired
    private HotelNumberService hotelNumberService;

    @Autowired
    private HotelNumberCategoryService hotelNumberCategoryService;

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/add")
    public String addNewHotelNumber(Model model){
        model.addAttribute("hotelNumberAdd", new HotelNumber());
        List<HotelNumberCategory> hotelNumberCategories = hotelNumberCategoryService.getAll();
        model.addAttribute("hotelCategories", hotelNumberCategories);
        List<Hotel> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "hotelNumberAdd";
    }

    @RequestMapping("/save")
    public String saveNewHotelNumber(@ModelAttribute("hotelNumberAdd") HotelNumber hotelNumber,
                                     @RequestParam Integer hotelCode,
                                     @RequestParam Integer hotelNumberCategoryId){
        Hotel hotel = hotelService.getBy(hotelCode);
        if (hotel != null){
            hotelNumber.setHotel(hotel);
        }
        HotelNumberCategory hotelNumberCategory = hotelNumberCategoryService.getBy(hotelNumberCategoryId);
        if (hotelNumberCategory != null){
            hotelNumber.setHotelNumberCategory(hotelNumberCategory);
        }
        hotelNumberService.insert(hotelNumber);
        return "redirect:/hotelNumber/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllHotelNumbers(Model model){
        List<HotelNumber> hotelNumbers = hotelNumberService.getAll();
        model.addAttribute("hotelNumbers", hotelNumbers);
        return "hotelNumberTable";
    }

    @RequestMapping("/edit")
    public String editHotelNumber(Model model, @RequestParam(value = "hotelNumberCode") Integer hotelNumberCode){
        HotelNumber hotelNumber = hotelNumberService.getBy(hotelNumberCode);
        model.addAttribute("hotelNumberEdit", hotelNumber);
        List<HotelNumberCategory> hotelNumberCategories = hotelNumberCategoryService.getAll();
        model.addAttribute("hotelCategories", hotelNumberCategories);
        List<Hotel> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "hotelNumberEdit";
    }

    @RequestMapping("/update")
    public String updateHotelNumber(@ModelAttribute("hotelNumberEdit") HotelNumber hotelNumber,
                                    @RequestParam Integer hotelCode,
                                    @RequestParam Integer hotelNumberCategoryId){
        Hotel hotel = hotelService.getBy(hotelCode);
        if (hotel != null){
            hotelNumber.setHotel(hotel);
        }
        HotelNumberCategory hotelNumberCategory = hotelNumberCategoryService.getBy(hotelNumberCategoryId);
        if (hotelNumberCategory != null){
            hotelNumber.setHotelNumberCategory(hotelNumberCategory);
        }
        hotelNumberService.update(hotelNumber);
        return "redirect:/hotelNumber/get-all";
    }

    @RequestMapping("/delete/{hotelNumberCode}")
    public String deleteHotelNumber(@PathVariable(value = "hotelNumberCode") Integer hotelNumberCode){
        hotelNumberService.delete(hotelNumberCode);
        return "redirect:/hotelNumber/get-all";
    }
}
