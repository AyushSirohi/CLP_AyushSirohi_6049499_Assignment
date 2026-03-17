package com.jpa.assignment;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;
    private String department;

    @ElementCollection
    private Set<String> mobileNumbers = new HashSet<>();

    public Employee() {
    }

    public Employee(int id, String name, double salary, String department, Set<String> mobileNumbers) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.mobileNumbers = mobileNumbers;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
                + ", department=" + department + ", mobileNumbers=" + mobileNumbers + "]";
    }
}