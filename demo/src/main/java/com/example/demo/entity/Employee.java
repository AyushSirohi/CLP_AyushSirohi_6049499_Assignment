package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee {

    @Id
    private int id;

    @NotBlank(message = "Employee name is required")
    private String name;

    @Min(value = 1, message = "Salary must be greater than 0")
    private double salary;

    @ElementCollection
    @CollectionTable(name = "employee_mobile_numbers", joinColumns = @JoinColumn(name = "employee_id"))
    @NotEmpty(message = "At least one mobile number is required")
    private Set<String> mobileNumbers;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Departement department;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }
}