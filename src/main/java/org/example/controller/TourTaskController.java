package org.example.controller;

import org.example.entities.Employee;
import org.example.entities.Tour;
import org.example.entities.TourTask;
import org.example.services.EmployeeService;
import org.example.services.TourService;
import org.example.services.TourTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tourTask")
public class TourTaskController {
    @Autowired
    private TourTaskService tourTaskService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/add")
    public String addNewTourTask(Model model){
        model.addAttribute("tTaskAdd", new TourTask());
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("empls", employees);
        return "tourTaskAdd";
    }

    @RequestMapping("/save")
    public String saveNewTourTask(@ModelAttribute("tTaskAdd") TourTask tourTask,
                               @RequestParam Integer tourNumber,
                               @RequestParam Integer passportNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            tourTask.setTour(tour);
        }
        Employee employee = employeeService.getBy(passportNumber);
        if (employee != null){
            tourTask.setEmployee(employee);
        }
        tourTaskService.insert(tourTask);
        return "redirect:/tourTask/get-all";
    }

    @RequestMapping("/get-all")
    public String showAllTourTasks(Model model){
        List<TourTask> tourTasks = tourTaskService.getAll();
        model.addAttribute("tTasks", tourTasks);
        return "tourTaskTable";
    }

    @RequestMapping("/edit")
    public String editTourTask(Model model, @RequestParam(value = "taskNumber") Integer taskNumber){
        TourTask tourTask = tourTaskService.getBy(taskNumber);
        model.addAttribute("tTaskEdit", tourTask);
        List<Tour> tours = tourService.getAll();
        model.addAttribute("tours", tours);
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("empls", employees);
        return "tourTaskEdit";
    }

    @RequestMapping("/update")
    public String updateTourTask(@ModelAttribute("tTaskEdit") TourTask tourTask,
                              @RequestParam Integer tourNumber,
                              @RequestParam Integer passportNumber){
        Tour tour = tourService.getBy(tourNumber);
        if (tour != null){
            tourTask.setTour(tour);
        }
        Employee employee = employeeService.getBy(passportNumber);
        if (employee != null){
            tourTask.setEmployee(employee);
        }
        tourTaskService.update(tourTask);
        return "redirect:/tourTask/get-all";
    }

    @RequestMapping("/delete/{taskNumber}")
    public String deleteTourTask(@PathVariable(value = "taskNumber") Integer taskNumber){
        tourTaskService.delete(taskNumber);
        return "redirect:/tourTask/get-all";
    }
}
