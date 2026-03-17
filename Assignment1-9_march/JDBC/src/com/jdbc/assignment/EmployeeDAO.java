package com.jdbc.assignment;

public interface EmployeeDAO {

    void createTable();
    void insertEmployee(Employee emp);
    void updateEmployee(int id, String name, double salary, String department);
    void deleteEmployee(int id);
    void fetchAllEmployees();
    void fetchEmployeeById(int id);
    void dropTable();
}