package org.example.controller;

import org.example.entities.Hotel;
import org.example.entities.HotelClass;
import org.example.entities.Tour;
import org.example.services.HotelClassService;
import org.example.services.HotelService;
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
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private TourService tourService;

    @Autowired
    private HotelClassService hotelClassService;

    @RequestMapping("/add")
    public String addNewHotel(Model model){
        model.addAttribute("hotelAdd", new Hotel());
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);
        List<HotelClass> hotelClasses = hotelClassService.getAll();
        model.addAttribute("allHotelClasses", hotelClasses);

        return "hotelAdd";
    }

    @RequestMapping("/save")
    public String saveNewHotel(@ModelAttribute("hotelAdd") Hotel hotel,
                               @RequestParam Integer tourNumber,
                               @RequestParam Integer hotelClassNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            hotel.setTour(tour);
        }
        HotelClass hotelClass = hotelClassService.getBy(hotelClassNumber);
        if(hotelClass != null){
            hotel.setHotelClass(hotelClass);
        }

        hotelService.insert(hotel);

        return "redirect:/hotel/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllHotels(Model model){
        List<Hotel> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "hotelTable";
    }

    @RequestMapping("/edit")
    public String editHotel(Model model, @RequestParam(value = "hotelCode") Integer hotelCode){
        Hotel hotel = hotelService.getBy(hotelCode);
        model.addAttribute("hotelEdit", hotel);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("allTours", tours);
        List<HotelClass> hotelClasses = hotelClassService.getAll();
        model.addAttribute("allHotelClasses", hotelClasses);

        return "hotelEdit";
    }

    @RequestMapping("/update")
    public String updateHotel(@ModelAttribute("hotelEdit") Hotel hotel,
                              @RequestParam Integer tourNumber,
                              @RequestParam Integer hotelClassNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            hotel.setTour(tour);
        }
        HotelClass hotelClass = hotelClassService.getBy(hotelClassNumber);
        if(hotelClass != null){
            hotel.setHotelClass(hotelClass);
        }
        hotelService.update(hotel);

        return "redirect:/hotel/get-all";
    }

    @RequestMapping("/delete/{hotelCode}")
    public String deleteEvent(@PathVariable(value = "hotelCode") Integer hotelCode){
        hotelService.delete(hotelCode);
        return "redirect:/hotel/get-all";
    }
}
