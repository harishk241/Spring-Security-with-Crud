package com.example.Employee.controller;

import com.example.Employee.dto.CreateEmployeeDTO;
import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }


    @DeleteMapping("/delete/{id}")
    public Long deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/create")
    public Long createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return employeeService.createEmployee(createEmployeeDTO);
    }
}
