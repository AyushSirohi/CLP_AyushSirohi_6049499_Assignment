package cg.demo.task4;

import java.util.List;

public class EmployeeDao {

    private List<Employee> employeeList;

    public EmployeeDao() {
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                return emp;
            }
        }
        return null;
    }
}