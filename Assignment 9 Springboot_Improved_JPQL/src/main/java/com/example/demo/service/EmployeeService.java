package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.DepartmentEmployeeCountDTO;
import com.example.demo.controller.dto.EmployeeDepartmentDTO;
import com.example.demo.controller.dto.EmployeeMobileSearchDTO;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Map<Integer, Departement> departmentMap = new HashMap<>();

    public Employee insertEmployee(Employee employee, int deptId) {
        Departement dept = departmentMap.get(deptId);

        if (dept != null) {
            employee.setDepartment(dept);
        }

        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public List<EmployeeDepartmentDTO> getAllEmployeeDepartmentDetails() {
        List<EmployeeDepartmentDTO> list = new ArrayList<>();

        for (Employee e : employeeMap.values()) {
            Departement d = e.getDepartment();

            if (d != null) {
                list.add(new EmployeeDepartmentDTO(
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        d.getName(),
                        d.getManagerName()
                ));
            }
        }

        return list;
    }

    public List<DepartmentEmployeeCountDTO> getEmployeeCountByDepartment() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Employee e : employeeMap.values()) {
            Departement d = e.getDepartment();

            if (d != null) {
                String deptName = d.getName();
                countMap.put(deptName, countMap.getOrDefault(deptName, 0) + 1);
            }
        }

        List<DepartmentEmployeeCountDTO> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            list.add(new DepartmentEmployeeCountDTO(entry.getKey(), entry.getValue()));
        }

        return list;
    }

    public List<Employee> getEmployeesByDepartmentName(String deptName) {
        List<Employee> list = new ArrayList<>();

        for (Employee e : employeeMap.values()) {
            Departement d = e.getDepartment();

            if (d != null && d.getName().equalsIgnoreCase(deptName)) {
                list.add(e);
            }
        }

        return list;
    }

    public EmployeeMobileSearchDTO getEmployeeDepartmentByMobile(String mobile) {
        for (Employee e : employeeMap.values()) {
            if (e.getMobileNumbers() != null && e.getMobileNumbers().contains(mobile)) {
                Departement d = e.getDepartment();

                if (d != null) {
                    return new EmployeeMobileSearchDTO(
                            e.getId(),
                            e.getName(),
                            d.getId(),
                            d.getName(),
                            d.getManagerName()
                    );
                }
            }
        }

        return null;
    }

    public void addDepartment(Departement department) {
        departmentMap.put(department.getId(), department);
    }
}