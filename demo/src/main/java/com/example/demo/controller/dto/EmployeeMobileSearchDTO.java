package com.example.demo.controller.dto;

public class EmployeeMobileSearchDTO {

    private int employeeId;
    private String employeeName;
    private int departmentId;
    private String departmentName;
    private String managerName;

    public EmployeeMobileSearchDTO(int employeeId, String employeeName, int departmentId, String departmentName, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManagerName() {
        return managerName;
    }
}