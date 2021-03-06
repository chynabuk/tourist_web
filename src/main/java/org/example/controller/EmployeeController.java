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
        model.addAttribute("empAdd", new Employee());
        List<Position> positions = positionService.getAll().subList(0, 4);
        model.addAttribute("allPos", positions);
        return "employeeSaveForm";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute("empAdd") Employee employee, @RequestParam Integer positionId){
        Position position = positionService.getBy(positionId);
        employee.setPosition(position);
        employeeService.insert(employee);
        return "redirect:/employee/get-all";
    }

    @RequestMapping("/edit")
    public String editEmployee(Model model, @RequestParam Integer passportNumber){
        Employee employee = employeeService.getBy(passportNumber);
        model.addAttribute("empEdit", employee);
        List<Position> positions = positionService.getAll().subList(0, 4);
        model.addAttribute("allPos", positions);
        return "employeeEditForm";
    }

    @RequestMapping("/update")
    public String updateEmployee(@ModelAttribute("empEdit") Employee employee, @RequestParam Integer positionId){
        if (positionId != null){
            Position position = positionService.getBy(positionId);
            employee.setPosition(position);
        }
        employeeService.update(employee);

        return "redirect:/employee/get-all";
    }

    @RequestMapping("/delete/{passportNumber}")
    public String deleteEmployee(@PathVariable(value = "passportNumber") Integer passportNumber){
        employeeService.delete(passportNumber);
        return "redirect:/employee/get-all";
    }
}