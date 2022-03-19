package org.example.controller;

import org.example.entities.AviaClass;
import org.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private PositionService positionService;

    @Autowired
    private CountrySevice countrySevice;

    @Autowired
    private TourTypeService tourTypeService;

    @Autowired
    private HotelClassService hotelClassService;

    @Autowired
    private AviaClassService aviaClassService;

    @RequestMapping("/")
    public String mainPage(){
        addAll();
        return "index";
    }

    private void addAll(){
        positionService.addAll();
        countrySevice.addAll();
        tourTypeService.addAll();
        hotelClassService.addAll();
        aviaClassService.addAll();
    }


}
