package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Departement;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
@Validated
public class DepartementController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Departement addDepartment(@Valid @RequestBody Departement department) {
        return service.saveDepartment(department);
    }
}