package org.example.controller;

import org.example.entities.*;
import org.example.services.EmployeeService;
import org.example.services.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/add")
    public String addNewOrder(Model model){
        model.addAttribute("orderAdd", new Order());
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("empls", employees);
        return "orderAdd";
    }

    @RequestMapping("/save")
    public String saveNewOrder(@ModelAttribute("orderAdd") Order order,
                                @RequestParam Integer tourNumber,
                                @RequestParam Integer passportNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            order.setTour(tour);
        }
        Employee employee = employeeService.getBy(passportNumber);
        if (employee != null){
            order.setEmployee(employee);
        }
        orderService.insert(order);
        return "redirect:/order/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllOrders(Model model){
        List<Order> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "orderTable";
    }

    @RequestMapping("/edit")
    public String editOrder(Model model, @RequestParam(value = "orderNumber") Integer orderNumber){
        Order order = orderService.getBy(orderNumber);
        model.addAttribute("orderEdit", order);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("empls", employees);
        return "orderEdit";
    }

    @RequestMapping("/update")
    public String updateOrder(@ModelAttribute("orderEdit") Order order,
                              @RequestParam Integer tourNumber,
                              @RequestParam Integer passportNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            order.setTour(tour);
        }
        Employee employee = employeeService.getBy(passportNumber);
        if (employee != null){
            order.setEmployee(employee);
        }
        orderService.update(order);
        return "redirect:/order/get-all";
    }

    @RequestMapping("/delete/{orderNumber}")
    public String deleteOrder(@PathVariable(value = "orderNumber") Integer orderNumber){
        orderService.delete(orderNumber);
        return "redirect:/order/get-all";
    }
}
