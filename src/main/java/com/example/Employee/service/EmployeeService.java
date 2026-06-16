package com.example.Employee.service;

import com.example.Employee.dto.CreateEmployeeDTO;
import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployees(){
        List<Employee> emp = employeeRepository.findAll();
        List<EmployeeDTO> empDtos = new ArrayList<>();
        for(Employee e : emp ){
            EmployeeDTO empDto = new EmployeeDTO();
            empDto.setId(e.getId());
            empDto.setDepartment(e.getDepartment());
            empDto.setName(e.getName());
            empDto.setRole(e.getRole());
            empDtos.add(empDto);
        }
        return  empDtos;

    }

    public EmployeeDTO getEmployee(Long id) {
        Employee e = employeeRepository.findById(id).orElseThrow();
        EmployeeDTO empDto = new EmployeeDTO();
        empDto.setId(e.getId());
        empDto.setDepartment(e.getDepartment());
        empDto.setName(e.getName());
        empDto.setRole(e.getRole());
        return empDto;
    }

    public Long deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return 1L;
    }

    public Long createEmployee(CreateEmployeeDTO createEmployeeDTO){
        Employee emp = new Employee();
        emp.setDepartment(createEmployeeDTO.getDepartment());
        emp.setName(createEmployeeDTO.getName());
        emp.setRole(createEmployeeDTO.getRole());
        employeeRepository.save(emp);
        return 1L;
    }
}
