package org.example.controller;

import org.example.entities.HotelNumberCategory;
import org.example.services.HotelNumberCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotelNumberCategory")
public class HotelNumberCategoryController {
    @Autowired
    private HotelNumberCategoryService hotelNumberCategoryService;

    @RequestMapping("/get-all")
    public String getAllHotelNumberCategories(Model model){
        List<HotelNumberCategory> hotelNumberCategories = hotelNumberCategoryService.getAll();
        hotelNumberCategories.forEach(p -> System.out.println(p.getHotelNumberCategoryEnum().toString()));
        model.addAttribute("allCategories", hotelNumberCategories);
        return "hotelNumberCategoryTable";
    }
}
