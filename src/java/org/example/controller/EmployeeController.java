package org.example.controller;

import org.example.entities.Employee;
import org.example.entities.Position;
import org.example.services.EmployeeService;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @RequestMapping("/get-all")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAll();
        model.addAttribute("allEmps", allEmployees);
        return "employeeTable";
    }

    @RequestMapping("/add-form")
    public String addNewEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeSaveForm";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @RequestParam Integer positionId){
        Position position = positionService.getBy(positionId);
        System.out.println(positionId);
        employee.setPosition(position);
        employeeService.insert(employee);
        return "redirect:/employee/get-all";
    }

    @RequestMapping("/edit/{passportNumber}")
    public String editEmployee(@PathVariable(value = "passportNumber") Integer passportNumber, Model model){
        model.addAttribute("employee", employeeService.getBy(passportNumber));
        return "employeeSaveForm";
    }

    @RequestMapping("/delete/{passportNumber}")
    public String deleteEmployee(@PathVariable(value = "passportNumber") Integer passportNumber){
        employeeService.delete(passportNumber);
        return "redirect:/employee/get-all";
    }
}