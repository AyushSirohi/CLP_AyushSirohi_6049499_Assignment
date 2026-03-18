package cg.demo.task4;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService() {
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee getEmployeeDetails(int id) {
        return employeeDao.getEmployeeById(id);
    }
}