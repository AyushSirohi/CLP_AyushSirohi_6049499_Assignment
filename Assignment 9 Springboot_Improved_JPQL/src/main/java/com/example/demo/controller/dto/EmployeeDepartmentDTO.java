package com.example.demo.controller.dto;

public class EmployeeDepartmentDTO {

    private int employeeId;
    private String employeeName;
    private double salary;
    private String departmentName;
    private String managerName;

    public EmployeeDepartmentDTO(int employeeId, String employeeName, double salary, String departmentName, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManagerName() {
        return managerName;
    }
}