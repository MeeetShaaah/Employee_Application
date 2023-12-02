package com.luv2code.springboot.Employee_Thymeleaf.controller;

import com.luv2code.springboot.Employee_Thymeleaf.entity.Employee;
import com.luv2code.springboot.Employee_Thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployee(Model theModel) {
        //Get the employees from db via Employee Service and Employee Repository
        List<Employee> theEmployee = employeeService.findAll();

        //Add into model
        theModel.addAttribute("employees", theEmployee);

        return "employees/list-employees";
    }
}
