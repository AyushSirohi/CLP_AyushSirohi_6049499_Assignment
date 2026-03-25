package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.dto.DepartmentEmployeeCountDTO;
import com.example.demo.controller.dto.EmployeeDepartmentDTO;
import com.example.demo.controller.dto.EmployeeMobileSearchDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/{deptId}")
    public Employee insertEmployee(@Valid @RequestBody Employee employee, @PathVariable int deptId) {
        return service.insertEmployee(employee, deptId);
    }

    @GetMapping("/details")
    public List<EmployeeDepartmentDTO> getAllEmployeeDepartmentDetails() {
        return service.getAllEmployeeDepartmentDetails();
    }

    @GetMapping("/count")
    public List<DepartmentEmployeeCountDTO> getEmployeeCountByDepartment() {
        return service.getEmployeeCountByDepartment();
    }

    @GetMapping("/department/{deptName}")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String deptName) {
        return service.getEmployeesByDepartmentName(deptName);
    }

    @GetMapping("/mobile/{mobile}")
    public EmployeeMobileSearchDTO getEmployeeDepartmentByMobile(@PathVariable String mobile) {
        return service.getEmployeeDepartmentByMobile(mobile);
    }
}