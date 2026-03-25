package com.example.demo.controller.dto;

public class DepartmentEmployeeCountDTO {

    private String departmentName;
    private long employeeCount;

    public DepartmentEmployeeCountDTO(String departmentName, long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }
}