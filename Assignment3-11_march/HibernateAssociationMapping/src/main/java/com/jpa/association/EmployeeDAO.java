package com.jpa.association;

public interface EmployeeDAO {

    void insertEmployee(Employee emp, Department dept);

    void fetchAllEmployees();

    void countEmployeesByDepartment();

    void employeesByDepartmentName(String deptName);

    void departmentDetailsByMobile(String mobile);
}