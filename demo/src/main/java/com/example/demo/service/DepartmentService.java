package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Departement;

@Service
public class DepartmentService {

    @Autowired
    private EmployeeService employeeService;

    public Departement saveDepartment(Departement department) {
        employeeService.addDepartment(department);
        return department;
    }
}