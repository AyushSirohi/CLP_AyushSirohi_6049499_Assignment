package com.jpa.assignment;

public interface EmployeeDAO {

    void insertEmployee(Employee emp);
    void updateEmployee(int id, String name, double salary, String department);
    void deleteEmployee(int id);
    void fetchAllEmployees();
    void fetchEmployeeById(int id);
    void fetchEmployeeBySalary(double salary);
    void fetchAllEmployeesSortedBySalary();
    void fetchEmployeeByMobileNumber(String mobileNumber);
}