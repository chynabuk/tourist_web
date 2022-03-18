package org.example.controller;

import org.example.services.CountrySevice;
import org.example.services.PositionService;
import org.example.services.TourTypeService;
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

    @RequestMapping("/")
    public String mainPage(){
        addAll();
        return "index";
    }

    private void addAll(){
        positionService.addAll();
        countrySevice.addAll();
        tourTypeService.addAll();
    }


}
